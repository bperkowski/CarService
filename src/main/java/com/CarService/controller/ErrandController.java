package com.CarService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CarService.model.CarPart;
import com.CarService.model.DetailsErrand;
import com.CarService.model.Errand;
import com.CarService.model.User;
import com.CarService.service.CarPartService;
import com.CarService.service.DetailsErrandSevice;
import com.CarService.service.ErrandService;
import com.CarService.service.UserService;
import com.CarService.utility.Utility;

@Controller
public class ErrandController {

	@Autowired
	private CarPartService carPartService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ErrandService errandService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private DetailsErrandSevice detailsErrandService;
	
	@GetMapping("/errand")
	@Secured("ROLE_ADMIN")
	public String getCreateErrandForm(Model model, HttpSession session) {
		if(session.getAttribute("carParts")==null) {
			List<CarPart> carParts = carPartService.getAvailableParts();
			session.setAttribute("carParts", carParts);
			model.addAttribute("carParts",carParts);
		} else {
			model.addAttribute("basket",session.getAttribute("basket"));
			model.addAttribute("carParts",session.getAttribute("carParts"));
		}
		return "Errand/ErrandCarParts";
	}

	@GetMapping("errand/addToCart")
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	public String addProductToBasket(@RequestParam("id") int carPartId, 
			HttpSession session, Model model) {
		CarPart carPart = carPartService.getCarPart(carPartId);
		List<CarPart> carParts = (List<CarPart>)session.getAttribute("carParts");
		List<DetailsErrand> basket = new ArrayList<DetailsErrand>();
		if(session.getAttribute("basket")!=null) {
			basket = (List<DetailsErrand>)session.getAttribute("basket");
		}
		DetailsErrand detailsErrand = new DetailsErrand();
		detailsErrand.setCarPart(carPart);
		detailsErrand.setQuantity(1);
		detailsErrand.setPrice(carPart.getPrice());
		basket.add(detailsErrand);
		carParts.removeIf(c -> c.getId()==carPart.getId());
		session.setAttribute("carParts", carParts);
		session.setAttribute("basket", basket);
		return "redirect:/errand";
	}

	@GetMapping("errand/basket")
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	public String getBasket(HttpSession session, Model model) {
		List<DetailsErrand> basket = new ArrayList<DetailsErrand>();
		if(session.getAttribute("basket")!=null) {
			basket = (List<DetailsErrand>)session.getAttribute("basket");
		}
		session.setAttribute("basket", basket);
		model.addAttribute("basket", basket);
		return "Errand/Basket";
	}

	@GetMapping("errand/modify")
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	public String changeQuantityProductInBasket(@RequestParam("id") int carPartId, 
			@RequestParam("quantity") int quantity, HttpSession session, Model model) {
		List<DetailsErrand> basket = (List<DetailsErrand>)session.getAttribute("basket");
		for (DetailsErrand detailsErrand : basket) {
			if(detailsErrand.getCarPart().getId()==carPartId) {
				detailsErrand.setQuantity(quantity);
				detailsErrand.setPrice(quantity*detailsErrand.getCarPart().getPrice());
			}
		}
		session.setAttribute("basket", basket);
		model.addAttribute("basket", basket);
		return "Errand/Basket";
	}

	@GetMapping("errand/basket/delete")
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	public String deleteCarPartFromBasket(@RequestParam("id") int carPart,
			HttpSession session) {
		List<CarPart> carParts = (List<CarPart>)session.getAttribute("carParts");
		List<DetailsErrand> basket = (List<DetailsErrand>)session.getAttribute("basket");
		carParts.add(basket.stream().filter(x -> x.getCarPart().getId()==carPart).findAny().get().getCarPart());
		basket.removeIf(d -> d.getCarPart().getId()==carPart);
		session.setAttribute("carParts", carParts);
		session.setAttribute("basket", basket);
		return "Errand/Basket";
	}

	@GetMapping("errand/basket/finalize")
	@SuppressWarnings("unchecked")
	@Secured("ROLE_ADMIN")
	public String finalizeErrand(HttpSession session, Model model, 
			Locale locale, Authentication auth, RedirectAttributes redirectAttributes) {
		List<DetailsErrand> basket = (List<DetailsErrand>)session.getAttribute("basket");
		User user = userService.findUserByEmail(auth.getName());
		float errandAmount = 0;
		if(basket.size()!=0) {
			Errand errand = new Errand();
			errand.setDateOfErrand(Utility.getParsedDate());
			errand.setUser(user);
			errand.setStatus("Oczekiwanie na realizację");
			errand.setAmountOfProducts(basket.size());
			errand = errandService.createErrand(errand);
			for (DetailsErrand detailsErrand : basket) {
				errandAmount += detailsErrand.getPrice();
				detailsErrand.setErrand(errand);
				detailsErrandService.CreateDetailsErrand(detailsErrand);
			}
			errand.setAmount(errandAmount);
			errandService.updateErrand(errand);
			session.removeAttribute("carParts");
			session.removeAttribute("basket");
			redirectAttributes.addAttribute("message", messageSource.getMessage("errand.add.success",
					null, locale));
			redirectAttributes.addAttribute("type", "success");
			return "redirect:/home";
		} else {
			session.setAttribute("alert", "yes");
			return "Errand/Basket";
		}
	}

	@GetMapping("/errands")
	@Secured({"ROLE_ADMIN","ROLE_DYSTRYBUTOR"})
	public String getErrands(@RequestParam(value = "status", required = false) String status, 
			Model model) {
		List<Errand> errands = new ArrayList<Errand>();
		if(status==null) {
			errands = errandService.getAllErrands();
		} else {
			errands = errandService.getAllErrandsWithStatus(status);
		}
		model.addAttribute("errands", errands);
		return "Errand/Errands";
	}
	
	@GetMapping("errand/")
	@Secured({"ROLE_ADMIN","ROLE_DYSTRYBUTOR"})
	public String getErrand(@RequestParam("id") int errandId, Model model) {
		model.addAttribute("errand", errandService.getErrand(errandId));
		model.addAttribute("detailsErrand", 
				detailsErrandService.getAllDetailsErrandWithIdErrand(errandId));
		return "Errand/Errand";
	}

	@GetMapping("errand/status")
	@Secured({"ROLE_ADMIN","ROLE_DYSTRYBUTOR"})
	public String updateStatus(@RequestParam("id") int errandId,
			@RequestParam("value") String status) {
		Errand errand = errandService.getErrand(errandId);
		errand.setStatus(status);
		errandService.updateErrand(errand);
		return "redirect:/errands";
	}
	
	@PostMapping("errand/status")
	@Secured("ROLE_DYSTRYBUTOR")
	public String updateStatusForm(@ModelAttribute("errand") Errand errand) {
		Errand updateErrand = errandService.getErrand(errand.getId());
		updateErrand.setStatus(errand.getStatus());
		errandService.updateErrand(updateErrand);
		return "redirect:/errands";
	}
}

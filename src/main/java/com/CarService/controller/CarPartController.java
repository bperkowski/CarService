package com.CarService.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CarService.model.CarPart;
import com.CarService.service.CarPartService;
import com.CarService.validator.AddCarPartFormValid;

@Controller
public class CarPartController {

	@Autowired
	private CarPartService carPartService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("carPart/add")
	@Secured("ROLE_DYSTRYBUTOR")
	public String getAddCarPartForm(Model model) {
		model.addAttribute("carPart", new CarPart());
		return "CarPart/CarPartAdd";
	}
	
	@PostMapping("carPart/add")
	@Secured("ROLE_DYSTRYBUTOR")
	public String addCarPart(@ModelAttribute("carPart") @Valid CarPart carPart,
			BindingResult result, Model model, Locale locale,
			RedirectAttributes redirectAttributes) {
		new AddCarPartFormValid().validate(carPart, result);
		if(result.hasErrors()) {
			return "CarPartAdd";
		}
		carPartService.createCarPart(carPart);
		redirectAttributes.addAttribute("message",  messageSource.getMessage("carPart.add.success",
				null, locale));
		redirectAttributes.addAttribute("type", "success");
		return "redirect:/home";
	}

	@GetMapping("carParts")
	@Secured("ROLE_DYSTRYBUTOR")
	public String getCarParts(Model model) {
		List<CarPart> carParts = carPartService.getCarParts();
		model.addAttribute("carParts", carParts);
		return "CarPart/CarParts";
	}
	
	@GetMapping("carParts/update")
	@Secured("ROLE_DYSTRYBUTOR")
	public String getUpdateCarPartForm(@RequestParam("id") int carPartId,
			Model model) {
		CarPart carPart = carPartService.getCarPart(carPartId);
		model.addAttribute("carPart", carPart);
		return "CarPart/CarPartUpdate";
	}
	
	@PostMapping("carParts/update")
	@Secured("ROLE_DYSTRYBUTOR")
	public String updateCarPart(@ModelAttribute("carPart") @Valid CarPart carPart,
			BindingResult result, Model model, Locale locale,
			RedirectAttributes redirectAttributes) {
		new AddCarPartFormValid().validate(carPart, result);
		if(result.hasErrors()) {
			return "CarPart/CarPartUpdate";
		}
		carPartService.updateCarPart(carPart);
		redirectAttributes.addAttribute("message",  messageSource.getMessage("carPart.update.success",
				null, locale));
		redirectAttributes.addAttribute("type", "success");
		return "redirect:/home";
	}
}

package com.CarService.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CarService.model.Booking;
import com.CarService.model.Car;
import com.CarService.model.User;
import com.CarService.service.BookingService;
import com.CarService.service.CarService;
import com.CarService.service.UserService;
import com.CarService.validator.CarAddFormValid;

@Controller
public class CarController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/carList")
	@Secured({"ROLE_KLIENT","ROLE_ADMIN"})
	public String getCars(Model model, HttpSession session) {
		List<Car> carList = carService.getCarListByUserId((int)session.getAttribute("id"));
		model.addAttribute("CarList", carList);
		return "Car/CarList";
	}
	
	@GetMapping("/addCar")
	@Secured("ROLE_KLIENT")
	public String getAddCarForm(Model model) {
		model.addAttribute("Car", new Car());
		return "Car/CarAddForm";
	}
	
	@PostMapping("/addCar")
	@Secured("ROLE_KLIENT")
	public String addCar(Authentication auth, @ModelAttribute("Car") @Valid Car car,
			BindingResult result, Locale locale, Model model,
			RedirectAttributes redirectAttributes) {
		new CarAddFormValid().validate(car, result);
		if(result.hasErrors()) {
			return "Car/CarAddForm";
		} else {
			User user = userService.findUserByEmail(auth.getName());
			car.setUser(user);
			carService.addCar(car);
			redirectAttributes.addAttribute("message",  messageSource.getMessage("car.addCar.success",
					null, locale));
			redirectAttributes.addAttribute("type", "success");
			return "redirect:/home";	
		}
	}
	
	@GetMapping("/carList/update")
	@Secured("ROLE_KLIENT")
	public String getUpdateCarForm(@RequestParam("id") int carId, Model model) {
		Car car = carService.getCar(carId);
		model.addAttribute("Car", car);
		return "Car/CarUpdateForm";
	}
	
	@PostMapping("/carList/update")
	@Secured("ROLE_KLIENT")
	public String updateCar(Authentication auth ,@ModelAttribute("Car") @Valid Car car,
			BindingResult result, Locale locale, Model model,
			RedirectAttributes redirectAttributes){
		new CarAddFormValid().validate(car, result);
		if(result.hasErrors()) {
			return "Car/CarUpdateForm";
		} else {
			User user = userService.findUserByEmail(auth.getName());
			car.setUser(user);
			carService.updateCar(car);
			redirectAttributes.addAttribute("message",  messageSource.getMessage("car.updateCar.success",
					null, locale));
			redirectAttributes.addAttribute("type", "success");
			return "redirect:/home";	
		}
	}
	
	@GetMapping("/carList/delete")
	@Secured("ROLE_KLIENT")
	public String deleteCar(@RequestParam("id") int carId, Model model, Locale locale,
			HttpSession session, RedirectAttributes redirectAttributes) {
		try {
			carService.deleteCar(carId);
			redirectAttributes.addAttribute("message", messageSource.getMessage("car.deleteCar.succes", 
					null, locale));
			redirectAttributes.addAttribute("type", "success");
			return "redirect:/home";
		} catch (Exception e) {
			redirectAttributes.addAttribute("message", messageSource.getMessage("car.deleteCar.error", 
					null, locale));
			redirectAttributes.addAttribute("type","error");
			return "redirect:/home";
		}
	}
	
	@GetMapping("/carList/repairHistory")
	@Secured("ROLE_KLIENT")
	public String getCarReapirHistory(@RequestParam("id") int carId, Model model) {
		List<Booking> repairHistory = bookingService.getAllCarReservations(carId);
		model.addAttribute("bookingList", repairHistory);
		return "Booking/BookingList";
	}
}

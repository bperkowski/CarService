package com.CarService.controller;

import java.util.Arrays;
import java.util.HashSet;
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
import com.CarService.utility.EmailSender;
import com.CarService.utility.Utility;
import com.CarService.validator.AddCustomerFormValid;
import com.CarService.validator.CarAddFormValid;
import com.CarService.validator.RegistryFormValid;
import com.CarService.validator.UpdateCustomerDataValid;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private EmailSender emailSender;
	
	@GetMapping("/booking")
	@Secured({"ROLE_KLIENT", "ROLE_ADMIN", "ROLE_PRACOWNIK", "ROLE_DYSTRYBUTOR"})
	public String getBooking(@RequestParam("id") int bookingId, 
			Model model) {
		Booking booking = bookingService.getBooking(bookingId);
		Car car = carService.getCar(booking.getCar().getId());
		User user = userService.findUserById(car.getUser().getId());
		List<Booking> bookingList = bookingService.getAllCarReservations(car.getId());
		model.addAttribute("booking", booking);
		model.addAttribute("user", user);
		model.addAttribute("car", car);
		model.addAttribute("bookingList", bookingList);
		return "Booking/BookingDetails";
	}
	
	@GetMapping("/bookings")
	@Secured({"ROLE_KLIENT", "ROLE_ADMIN", "ROLE_PRACOWNIK"})
	public String getAllBookings(@RequestParam(value="status", required=false) String status,
			Model model, Authentication auth){
		List<Booking> bookingList;
		if(status!=null) {
			bookingList = bookingService.getAllBookingWithStatus(status);
		} else {
			bookingList = bookingService.getAllBooking();
		}
		model.addAttribute("bookingList", bookingList);
		return "Booking/BookingListEmployee";
	}
	
	@GetMapping("/myBooking")
	@Secured({"ROLE_KLIENT", "ROLE_PRACOWNIK"})
	public String getMyBooking(@RequestParam(value="status", required=false) String status,
			Model model, HttpSession session) {
		List<Booking> bookingList;
		if(status!=null) {
			bookingList = bookingService.getAllCustomerReservationsWithStatus(
					(int)session.getAttribute("id"), status);
		} else {
			bookingList = bookingService.getAllCustomerReservation(
					(int)session.getAttribute("id"));
		}
		model.addAttribute("bookingList", bookingList);
		return "Booking/BookingList";
	}
	
	@GetMapping("/booking/delete")
	@Secured("ROLE_ADMIN")
	public String deleteBooking(@RequestParam("id") int id, Model model,
			Locale locale, RedirectAttributes redirectAttributes) {
		bookingService.deleteBooking(id);
		redirectAttributes.addAttribute("message", messageSource.getMessage("booking.delete.success",
				null, locale));
		redirectAttributes.addAttribute("type", "success");
		return "redirect:/home";
	}
	
	@GetMapping("/booking/step1")
	@Secured({"ROLE_ADMIN", "ROLE_KLIENT"})
	public String getBookingStep1(@RequestParam(value = "type",required=false) String type,
			HttpSession session) {
		if(type!=null) {
			session.setAttribute("type", type);
			return "redirect:/booking/step2";
		}
		return "Booking/BookingStep1";
	}

	@GetMapping("/booking/step2")
	@Secured({"ROLE_ADMIN", "ROLE_KLIENT"})
	public String getBookingStep2Form(Authentication auth, Model model) {
		User user;
		boolean disabled = false;
		if(auth.getAuthorities().toString().equalsIgnoreCase("[ROLE_KLIENT]")) {
			user = userService.findUserByEmail(auth.getName());
		} else {
			disabled = true;
			user = new User();
		}
		model.addAttribute("disabled", disabled);
		model.addAttribute("User", user);
		return "Booking/BookingStep2";
	}

	@GetMapping("/booking/step2/addCustomer")
	@Secured("ROLE_ADMIN")
	public String getBookingStep2AddCustomerForm(HttpSession session, Model model) {
		model.addAttribute("User", new User());
		return "Booking/BookingAddCustomer";
	}

	@PostMapping("/booking/step2/addCustomer")
	@Secured("ROLE_ADMIN")
	public String bookingStep2AddCustomer(@ModelAttribute("User") @Valid User user,
			BindingResult result, Authentication auth, Model model,
			HttpSession session) {
		User userExist = userService.findUserByEmail(user.getEmail());
		new RegistryFormValid().validateEmailExist(userExist, result);
		new AddCustomerFormValid().validate(user, result);
		if(result.hasErrors()) {
			return "Booking/BookingAddCustomer";
		} else {
			user.setActivationCode(Utility.randomStringGenerator());
			String contentPassword = "Hasło do konta: " + user.getPassword();
			String content = "Wymagane potwierdzenie rejestracji. Kliknij w poniższy link aby aktywować konto: " +
					"http://localhost:8080/CarService/activationLink/" + user.getActivationCode();
			userService.registryUser(user, 4);
			emailSender.sendEmail(user.getEmail(), "Hasło do konta", contentPassword);
			emailSender.sendEmail(user.getEmail(), "Potwierdzenie rejestracji", content);
		}
		User userBooking = userService.findUserByEmail(user.getEmail());
		System.out.println(userBooking.getEmail());
		model.addAttribute("disabled", true);
		model.addAttribute("User", userBooking);
		session.setAttribute("idCustomerBooking", user.getId());
		return "Booking/BookingStep2";
	}

	@GetMapping("/booking/step2/customers")
	@Secured("ROLE_ADMIN")
	public String getBookingStep2Customers(HttpSession session, Model model) {
		List<User> users = userService.getAllUserWithRole(4);
		model.addAttribute("Users", users);
		return "Booking/BookingCustomers";
	}

	@GetMapping("/booking/step2/customers/selectedCustomer")
	@Secured("ROLE_ADMIN")
	public String bookingStep2SelectedCustomer(@RequestParam("id") int customerId,
			Model model, HttpSession session) {
		User user = userService.findUserById(customerId);
		model.addAttribute("disabled", true);
		model.addAttribute("User", user);
		session.setAttribute("idCustomerBooking", user.getId());
		return "Booking/BookingStep2";
	}

	@PostMapping("/booking/step2")
	@Secured({"ROLE_ADMIN", "ROLE_KLIENT"})
	public String bookingStep2(@ModelAttribute("User") @Valid User user, 
			BindingResult result, Authentication auth, HttpSession session, Model model) {
		new UpdateCustomerDataValid().validate(user, result);
		boolean disabled = false;
		if(auth.getAuthorities().toString().equalsIgnoreCase("[ROLE_ADMIN]")) {
			disabled = true;
		}
		model.addAttribute("disabled", disabled);
		if(result.hasErrors()) {
			return "Booking/BookingStep2";
		} else {
			session.setAttribute("idCustomerBooking", user.getId());
			userService.updateUserData(user);
			return "redirect:/booking/step3";
		}
	}

	@GetMapping("/booking/step3")
	@Secured({"ROLE_KLIENT", "ROLE_ADMIN"})
	public String getBookingStep3Form(HttpSession session, Model model) {
		List<Car> cars = carService.getCarListByUserId((int)session.getAttribute("idCustomerBooking"));
		model.addAttribute("cars", cars);
		return "Booking/BookingStep3";
	}

	@GetMapping("/booking/step3/addCar")
	@Secured({"ROLE_KLIENT", "ROLE_ADMIN"})
	public String getBookigStep3AddCarForm(Model model) {
		Car car = new Car();
		model.addAttribute("Car", car);
		return "Booking/BookingAddCar";
	}

	@PostMapping("/booking/step3/addCar")
	@Secured({"ROLE_KLIENT", "ROLE_ADMIN"})
	public String bookigStep3AddCar(@ModelAttribute("Car") @Valid Car car, 
			BindingResult result, Locale locale, Model model, HttpSession session) {
		new CarAddFormValid().validate(car, result);
		if(result.hasErrors()) {
			return "Booking/BookingAddCar";
		} else {
			User user = userService.findUserById((int)session.getAttribute("idCustomerBooking"));
			car.setUser(user);
			carService.addCar(car);
			return "redirect:/booking/step3";	
		}
	}

	@GetMapping("/booking/step4")
	@Secured({"ROLE_KLIENT", "ROLE_ADMIN"})
	public String getBookingStep4Form(@RequestParam("id") int carId, Model model,
			HttpSession session) {
		model.addAttribute("booking", new Booking());
		session.setAttribute("carId", carId);
		return "Booking/BookingStep4";
	}

	@PostMapping("/booking/add")
	@Secured({"ROLE_KLIENT", "ROLE_ADMIN"})
	public String addBooking(@ModelAttribute("booking") Booking booking, HttpSession session, 
			Locale locale, Model model, Authentication auth, RedirectAttributes redirectAttributes) {
		String status;
		if(auth.getAuthorities().toString().equalsIgnoreCase("[ROLE_KLIENT]")) {
			status = "Oczekiwanie na realizację";
		} else {
			status = "W trakcie realizacji";
		}
		User user = userService.findUserById((int)session.getAttribute("idCustomerBooking"));
		Car car = carService.getCar((int)session.getAttribute("carId"));
		booking.setTypeOfService((String)session.getAttribute("type"));
		booking.setUser(new HashSet<User>(Arrays.asList(user)));
		booking.setCar(car);
		booking.setDateOfSubmission(Utility.getParsedDate());
		booking.setStatus(status);
		bookingService.saveBooking(booking);
		redirectAttributes.addAttribute("type", "success");
		redirectAttributes.addAttribute("message", messageSource.getMessage("booking.addBooking.success",
				null, locale));
		session.removeAttribute("carId");
		session.removeAttribute("idCustomerBooking");
		return "redirect:/home";
	}

	@GetMapping("/booking/status")
	@Secured({"ROLE_ADMIN", "ROLE_PRACOWNIK", "ROLE_KLIENT"})
	public String updateStatus(@RequestParam("id") int bookingId, @RequestParam("value") String status,
			RedirectAttributes redirectAttributes) {
		Booking booking = bookingService.getBooking(bookingId);
		booking.setStatus(status);
		bookingService.updateBooking(booking);
		redirectAttributes.addAttribute("id", bookingId);
		return "redirect:/booking";
	}

	@PostMapping("/booking/update")
	@Secured("ROLE_ADMIN")
	public String updateBooking(@ModelAttribute("booking") Booking booking,
			Model model, RedirectAttributes redirectAttributes) {
		Booking updateBooking = bookingService.getBooking(booking.getId());
		if(booking.getStatus()!=null) {
			updateBooking.setStatus(booking.getStatus());
		}
		if(booking.getDateOfAdmission()!=null) {
			updateBooking.setStatus("Negocjacje");
			updateBooking.setDateOfAdmission(booking.getDateOfAdmission());
		}
		if(booking.getPrice()!=0) {
			updateBooking.setStatus("Zakończone");
			updateBooking.setPrice(booking.getPrice());
		}
		bookingService.updateBooking(updateBooking);
		redirectAttributes.addAttribute("id", booking.getId());
		return "redirect:/booking";
	}
	
	@PostMapping("/booking/accept")
	@Secured({"ROLE_ADMIN", "ROLE_PRACOWNIK"})
	public String acceptBooking(@ModelAttribute("booking") Booking booking,
			Authentication auth, RedirectAttributes redirectAttributes) {
		User employee = userService.findUserByEmail(auth.getName());
		Booking acceptedBooking = bookingService.getBooking(booking.getId());
		acceptedBooking.getUser().add(employee);
		acceptedBooking.setLeadTime(booking.getLeadTime());
		bookingService.updateBooking(acceptedBooking);
		redirectAttributes.addAttribute("id", booking.getId());
		return "redirect:/booking";
	}
}

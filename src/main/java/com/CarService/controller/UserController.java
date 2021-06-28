package com.CarService.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
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

import com.CarService.model.User;
import com.CarService.service.UserService;
import com.CarService.utility.EmailSender;
import com.CarService.utility.Utility;
import com.CarService.validator.AddEmployeeFormValid;
import com.CarService.validator.RegistryFormValid;
import com.CarService.validator.UpdateCustomerDataValid;
import com.CarService.validator.UpdateEmployeeForm;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private EmailSender emailSender;
	
	@GetMapping("/update")
	@Secured("ROLE_KLIENT")
	public String getCompleteTheDataForm(Model model, HttpSession session) {
		User user = userService.findUserById((int)session.getAttribute("id"));
		model.addAttribute("User", user);
		return "User/UpdateUserData";
	}
	
	@PostMapping("/update")
	@Secured("ROLE_KLIENT")
	public String completeUserDataAction(@ModelAttribute("User") @Valid User user, 
			BindingResult result, Locale locale, Model model, 
			RedirectAttributes redirectAttributes) {
		new UpdateCustomerDataValid().validate(user, result);
		if(result.hasErrors()) {
			return "User/UpdateUserData";
		} else {
			userService.updateUserData(user);
			redirectAttributes.addAttribute("message", messageSource.getMessage("user.update.success",
					null, locale));
			redirectAttributes.addAttribute("type", "success");
			return "redirect:/home";	
		}
	}

	@GetMapping("/employee/add")
	@Secured("ROLE_ADMIN")
	public String getAddEmployeeForm(Model model) {
		model.addAttribute("User", new User());
		return "User/EmployeeAddForm";
	}
	
	@PostMapping("/employee/add")
	@Secured("ROLE_ADMIN")
	public String addEmployee(@ModelAttribute("User") @Valid User employee, 
			BindingResult result, Model model, Locale locale,
			RedirectAttributes redirectAttributes) {
		User userExist = userService.findUserByEmail(employee.getEmail());
		new RegistryFormValid().validateEmailExist(userExist, result);
		new AddEmployeeFormValid().validate(employee, result);
		if(result.hasErrors()) {
			return "User/EmployeeAddForm";
		} else {
			employee.setActivationCode(Utility.randomStringGenerator());
			String contentPassword = "Hasło do konta: " + employee.getPassword();
			String content = "Wymagane potwierdzenie rejestracji. Kliknij w poniższy link aby aktywować konto: " +
					"http://localhost:8080/CarService/activationLink/" + employee.getActivationCode();
			userService.registryUser(employee, 2);
			emailSender.sendEmail(employee.getEmail(), "Hasło do konta", contentPassword);
			emailSender.sendEmail(employee.getEmail(), "Potwierdzenie rejestracji", content);
			redirectAttributes.addAttribute("message", messageSource.getMessage("userEmployee.add.success",
					null, locale));
			redirectAttributes.addAttribute("type", "success");
			return "redirect:/home";
		}
	}

	@GetMapping("/workers")
	@Secured("ROLE_ADMIN")
	public String getWorkers(Model model) {
		List<User> workers = userService.getAllUserWithRole(2);
		model.addAttribute("workers", workers);
		return "User/EmployeeList";
	}

	@GetMapping("workers/update")
	@Secured("ROLE_ADMIN")
	public String changeEmployeeActiveOrGetUpdateEmployeeForm(@RequestParam(value = "id", required=false) int employeeId,
			@RequestParam(value = "isActive", required=false) Integer isActive, 
			Model model) {
		User employee = userService.findUserById(employeeId);
		if(isActive==null) {
			model.addAttribute("employee", employee);
			return "User/EmployeeUpdateForm";
		} else {
			employee.setIsActive(isActive);
			userService.updateUserData(employee);
			return "redirect:/workers";
		}	
	}
	
	@PostMapping("workers/update")
	@Secured("ROLE_ADMIN")
	public String updateEmployee(@ModelAttribute("employee") @Valid User employee, 
			BindingResult result, Model model, Locale locale,
			RedirectAttributes redirectAttributes) {
		new UpdateEmployeeForm().validate(employee, result);
		if(result.hasErrors()) {
			return "User/EmployeeUpdateForm";
		} else {
			userService.updateUserData(employee);
			redirectAttributes.addAttribute("message", messageSource.getMessage("user.update.success",
					null, locale));
			redirectAttributes.addAttribute("type", "success");
			return "redirect:/home";
		}
	}
}

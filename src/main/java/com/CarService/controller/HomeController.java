package com.CarService.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CarService.model.User;
import com.CarService.service.UserService;
import com.CarService.utility.EmailSender;
import com.CarService.utility.Utility;
import com.CarService.validator.RegistryFormValid;

@Controller
public class HomeController {
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/")
	public String getIndexPage(@RequestParam(value="message", required = false) String message,
			@RequestParam(value = "type", required = false) String type, Model model) {
		if(message!=null && type!=null) {
			model.addAttribute("message", message);
			model.addAttribute("type", type);
		}
		model.addAttribute("User", new User());
		return "Index";
	}
	
	@GetMapping("/login")
	public String getLoginForm(@RequestParam(value = "error", required=false) boolean error,
			Model model,HttpSession session, Locale locale) {
		if(error==true) {
			model.addAttribute("error", messageSource.getMessage("user.login.fail",
					null, locale));
		}
		model.addAttribute("showLoginModal", "true");
		model.addAttribute("User", new User());
		return "Index";
	}

	@GetMapping("/home")
	public String getHomePage(@RequestParam(value="message", required = false) String message,
			@RequestParam(value = "type", required = false) String type,
			HttpSession session, Authentication auth, Model model) {
		User user = userService.findUserByEmail(auth.getName());
		session.setAttribute("id", user.getId());
		if(message!=null && type!=null) {
			model.addAttribute("message", message);
			model.addAttribute("type", type);
		}
		return "HomePage";
	}

	@GetMapping("/logout")
	public String logout (Authentication auth,HttpServletRequest request, 
			HttpServletResponse response, HttpSession session) {
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	        session.invalidate();
	    }
	    return "redirect:/login?logout";
	}

	@GetMapping("/registry")
    public String getRegistryForm(Model model) {
		model.addAttribute("User", new User());
    	return "RegistryPage";
    }

	@PostMapping("/registry")
	public String registry(@ModelAttribute("User") @Valid User user, 
			BindingResult result, Locale locale, Model model) {
		User userExist = userService.findUserByEmail(user.getEmail());
		new RegistryFormValid().validateEmailExist(userExist, result);
		new RegistryFormValid().validate(user, result);
		if(result.hasErrors()) {
			return "RegistryPage";
		} else {
			user.setActivationCode(Utility.randomStringGenerator());
			String content = "Wymagane potwierdzenie rejestracji. Kliknij w poniższy link aby aktywować konto: " +
					"http://localhost:8080/CarService/activationLink/" + user.getActivationCode();
			userService.registryUser(user, 4);
			emailSender.sendEmail(user.getEmail(), "Potwierdzenie rejestracji", content);
			model.addAttribute("message", 
					messageSource.getMessage("user.register.success",null, locale));
			model.addAttribute("type", "info");
			model.addAttribute("User", new User());
		}
		return "Index";
	}
	
	@GetMapping("/activationLink/{activationCode}")
	public String activateAccount(@PathVariable("activationCode") String activationCode,
			Model model, Locale locale, RedirectAttributes redirectAttributes) {
		userService.updateUserActivation(1, activationCode);
		redirectAttributes.addAttribute("message", 
				messageSource.getMessage("user.registerActivate.success",null, locale));
		redirectAttributes.addAttribute("type", "success");
		return "redirect:/";
	}
}

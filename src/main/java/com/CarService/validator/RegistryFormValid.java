package com.CarService.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.CarService.model.User;

public class RegistryFormValid implements Validator {

	private static final Pattern EMAIL_REGEX = 
			Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "name", "user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "user.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "surname", "user.surname.empty");
		if (user.getPassword() != null && user.getPassword().contains(" ")) {
			errors.rejectValue("password", "user.password.space");
		}
		if (user.getPassword() != null && user.getPassword().length() < 8) {
			errors.rejectValue("password", "user.password.size");
		}
		if (user.getEmail().isEmpty() == false 
				&& !EMAIL_REGEX.matcher(user.getEmail()).matches()) {
			errors.rejectValue("email", "user.email.fail");
		}
	}
	
	public void validateEmailExist(User user, Errors errors) {
		if (user != null) {
			errors.rejectValue("email", "user.email.exist");
		}
	}

}

package com.CarService.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.CarService.model.User;

public class AddCustomerFormValid implements Validator {

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
		ValidationUtils.rejectIfEmpty(errors, "surname", "user.surname.empty");
		ValidationUtils.rejectIfEmpty(errors, "adres", "user.adres.empty");
		ValidationUtils.rejectIfEmpty(errors, "dateOfBirth", "user.dateOfBirth.empty");
		ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "user.phoneNumber.empty");
		ValidationUtils.rejectIfEmpty(errors, "pesel", "user.pesel.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "user.email.empty");
		
		if (user.getPesel().length() != 0 && user.getPesel().length() != 11) {
			errors.rejectValue("pesel", "user.pesel.invalid");
		}
		if (user.getPhoneNumber().length() != 0 && user.getPhoneNumber().length() != 9) {
			errors.rejectValue("phoneNumber", "user.phoneNumber.invalid");
		}
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
	
}

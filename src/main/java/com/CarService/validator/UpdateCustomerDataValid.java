package com.CarService.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.CarService.model.User;

public class UpdateCustomerDataValid implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "surname", "user.surname.empty");
		ValidationUtils.rejectIfEmpty(errors, "adres", "user.adres.empty");
		ValidationUtils.rejectIfEmpty(errors, "dateOfBirth", "user.dateOfBirth.empty");
		ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "user.phoneNumber.empty");
		ValidationUtils.rejectIfEmpty(errors, "pesel", "user.pesel.empty");
		User user = (User) target;

		if (user.getPesel().length() != 0 && user.getPesel().length() != 11) {
			errors.rejectValue("pesel", "user.pesel.invalid");
		}
		if (user.getPhoneNumber().length() != 0 && user.getPhoneNumber().length() != 9) {
			errors.rejectValue("phoneNumber", "user.phoneNumber.invalid");
		}
	}
}

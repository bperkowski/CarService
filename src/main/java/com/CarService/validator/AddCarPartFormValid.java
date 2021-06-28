package com.CarService.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.CarService.model.CarPart;

public class AddCarPartFormValid implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CarPart.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CarPart carPart = (CarPart)target;
		ValidationUtils.rejectIfEmpty(errors, "name", "carPart.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "manufacturer", "carPart.manufacturer.empty");
		ValidationUtils.rejectIfEmpty(errors, "price", "carPart.price.empty");
		if (carPart.getPrice()==0) {
	         errors.rejectValue("price", "carPart.price.zero");
	    }
	}
}

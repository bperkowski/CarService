package com.CarService.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.CarService.model.Car;

public class CarAddFormValid implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Car.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "theCarBrand", "car.theCarBrand.empty");
		ValidationUtils.rejectIfEmpty(errors, "carModel", "car.carModel.empty");
		ValidationUtils.rejectIfEmpty(errors, "registrationNumber", "car.registrationNumber.empty");
		ValidationUtils.rejectIfEmpty(errors, "VINnumber", "car.VINnumber.empty");
		ValidationUtils.rejectIfEmpty(errors, "carMileage", "car.carMileage.empty");
		ValidationUtils.rejectIfEmpty(errors, "yearOfProduction", "car.yearOfProduction.empty");
		ValidationUtils.rejectIfEmpty(errors, "engineCapacity", "car.engineCapacity.empty");
		ValidationUtils.rejectIfEmpty(errors, "fuelType", "car.fuelType.empty");
		ValidationUtils.rejectIfEmpty(errors, "enginePower", "car.enginePower.empty");
		
		Car car = (Car) target;
		if (car.getVINnumber() != null && car.getVINnumber().length() != 17) {
	         errors.rejectValue("VINnumber", "car.VINnumber.lenght");
	    } 
		if(car.getEngineCapacity()==0) {
			errors.rejectValue("engineCapacity", "car.engineCapacity.zero");
		} 
		if(car.getEnginePower()==0) {
			errors.rejectValue("enginePower", "car.enginePower.zero");
		}
	}

}

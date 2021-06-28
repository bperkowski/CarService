package com.CarService.service;

import java.util.List;

import com.CarService.model.CarPart;

public interface CarPartService {
	
	public List<CarPart> getAvailableParts ();
	
	public CarPart getCarPart(int carPartId);
	
	public void createCarPart(CarPart carPart);
	
	public List<CarPart> getCarParts();
	
	public void updateCarPart(CarPart carPart);
}

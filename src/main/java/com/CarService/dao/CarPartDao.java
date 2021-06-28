package com.CarService.dao;

import java.util.List;

import com.CarService.model.CarPart;

public interface CarPartDao {

	public List<CarPart> getAvailableParts ();
	
	public CarPart getCarPart(int carPartId);
	
	public void createCarPart(CarPart carPart);
	
	public List<CarPart> getCarParts();
	
	public void updateCarPart(CarPart carPart);
}

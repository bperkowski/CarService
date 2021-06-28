package com.CarService.service;

import java.util.List;

import com.CarService.model.Errand;

public interface ErrandService {
	
	public Errand createErrand(Errand errand);
	
	public void updateErrand(Errand errand);
	
	public List<Errand> getAllErrands();

	public Errand getErrand(int errandId);
	
	public List<Errand> getAllErrandsWithStatus(String status);
}

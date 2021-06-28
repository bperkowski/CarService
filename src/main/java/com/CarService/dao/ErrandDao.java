package com.CarService.dao;

import java.util.List;

import com.CarService.model.Errand;

public interface ErrandDao {

	public Errand createErrand(Errand errand);
	
	public void updateErrand(Errand errand);
	
	public List<Errand> getAllErrands();
	
	public Errand getErrand(int errandId);
	
	public List<Errand> getAllErrandsWithStatus(String status);
}

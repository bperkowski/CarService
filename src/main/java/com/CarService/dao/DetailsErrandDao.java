package com.CarService.dao;

import java.util.List;

import com.CarService.model.DetailsErrand;

public interface DetailsErrandDao {

	public void createDetailsErrand(DetailsErrand detailsErrand);
	
	public List<DetailsErrand> getAllDetailsErrandWithIdErrand(int errandId);
}

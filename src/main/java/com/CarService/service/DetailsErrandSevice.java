package com.CarService.service;

import java.util.List;

import com.CarService.model.DetailsErrand;

public interface DetailsErrandSevice {

	public void CreateDetailsErrand (DetailsErrand detailsErrand);
	
	public List<DetailsErrand> getAllDetailsErrandWithIdErrand(int errandId);
}

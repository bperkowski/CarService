package com.CarService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarService.dao.CarPartDao;
import com.CarService.model.CarPart;

@Service
@Transactional
public class CarPartServiceImpl implements CarPartService {
	
	@Autowired
	private CarPartDao carPartDao;
	
	@Override
	public List<CarPart> getAvailableParts(){
		return carPartDao.getAvailableParts();
	}
	
	@Override
	public CarPart getCarPart(int carPartId) {
		return carPartDao.getCarPart(carPartId);
	}
	
	@Override
	public void createCarPart(CarPart carPart) {
		carPartDao.createCarPart(carPart);
	}
	
	@Override
	public List<CarPart> getCarParts(){
		return carPartDao.getCarParts();
	}
	
	@Override
	public void updateCarPart(CarPart carPart) {
		carPartDao.updateCarPart(carPart);
	}
}

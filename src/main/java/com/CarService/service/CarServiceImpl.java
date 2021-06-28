package com.CarService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarService.dao.CarDao;
import com.CarService.model.Car;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;
	
	@Override
	public List<Car> getCarListByUserId(int id){
		return carDao.getCarListByUserId(id);
	}

	@Override
	public void addCar(Car car) {
		carDao.addCar(car);
	}
	
	@Override
	public Car getCar(int carId) {
		return carDao.getCar(carId);
	}
	
	@Override
	public void updateCar(Car car) {
		carDao.updateCar(car);
	}
	
	@Override
	public void deleteCar(int carId) {
		carDao.deleteCar(carId);
	}
}

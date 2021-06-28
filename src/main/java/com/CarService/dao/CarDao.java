package com.CarService.dao;

import java.util.List;

import com.CarService.model.Car;

public interface CarDao {
	
	public List<Car> getCarListByUserId(int id);
	
	public void addCar(Car car);
	
	public Car getCar(int carId);
	
	public void updateCar(Car car);
	
	public void deleteCar(int carId);
}

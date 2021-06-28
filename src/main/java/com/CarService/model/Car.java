package com.CarService.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Car")
public class Car {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "theCarBrand")
    private String theCarBrand;

    @Column(name = "carModel")
    private String carModel;
    
    @Column(name = "registrationNumber")
    private String registrationNumber;
    
    @Column(name = "VINnumber")
    private String VINnumber;
    
    @Column(name = "carMileage")
    private String carMileage;
    
    @Column(name = "yearOfProduction")
    @DateTimeFormat(pattern = "YYYY-MM")
    private Date yearOfProduction;
    
    @Column(name = "engineCapacity")
    private int engineCapacity;
    
    @Column(name = "fuelType")
    private String fuelType;
    
    @Column(name = "enginePower")
    private int enginePower;

    @ManyToOne 
    @JoinColumn(name = "userId") 
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTheCarBrand() {
		return theCarBrand;
	}

	public void setTheCarBrand(String theCarBrand) {
		this.theCarBrand = theCarBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getVINnumber() {
		return VINnumber;
	}

	public void setVINnumber(String vINnumber) {
		VINnumber = vINnumber;
	}

	public String getCarMileage() {
		return carMileage;
	}

	public void setCarMileage(String carMileage) {
		this.carMileage = carMileage;
	}

	public Date getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(Date yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    
}

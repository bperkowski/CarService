package com.CarService.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CarPart")
public class CarPart {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "name")
    private String name;
	
    @Column(name = "manufacturer")
    private String manufacturer;
    
    @Column(name = "price")
    private float price;
    
    @Column(name="availability")
    private boolean availability = false;
    
    @OneToMany(mappedBy = "carPart")
    private Set<DetailsErrand> detailsErrand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Set<DetailsErrand> getDetailsErrand() {
		return detailsErrand;
	}

	public void setDetailsErrand(Set<DetailsErrand> detailsErrand) {
		this.detailsErrand = detailsErrand;
	}
    
    
}

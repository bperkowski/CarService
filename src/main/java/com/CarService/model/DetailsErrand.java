package com.CarService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetailsErrand")
public class DetailsErrand {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private float price;
	
	@ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "errandId") 
    private Errand errand;
	
	@ManyToOne 
    @JoinColumn(name = "carPartId") 
    private CarPart carPart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Errand getErrand() {
		return errand;
	}

	public void setErrand(Errand errand) {
		this.errand = errand;
	}

	public CarPart getCarPart() {
		return carPart;
	}

	public void setCarPart(CarPart carPart) {
		this.carPart = carPart;
	}
	
	
}

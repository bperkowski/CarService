package com.CarService.model;

import java.time.LocalDate;

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
@Table(name = "Errand")
public class Errand {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "status")
    private String status;
    
    @Column(name = "dateOfErrand")
    @DateTimeFormat(pattern = "MM-DD-YYYY")
    private LocalDate dateOfErrand;
    
    @Column(name = "amountOfProducts")
    private int amountOfProducts;
    
    @Column(name = "amount")
    private float amount;
    
    @ManyToOne 
    @JoinColumn(name = "userId") 
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDateOfErrand() {
		return dateOfErrand;
	}

	public void setDateOfErrand(LocalDate dateOfErrand) {
		this.dateOfErrand = dateOfErrand;
	}

	public int getAmountOfProducts() {
		return amountOfProducts;
	}

	public void setAmountOfProducts(int amountOfProducts) {
		this.amountOfProducts = amountOfProducts;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}

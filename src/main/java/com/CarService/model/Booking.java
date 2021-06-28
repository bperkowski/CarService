package com.CarService.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Booking")
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "typeOfService")
    private String typeOfService;
    
    @Column(name = "dateOfSubmission")
    @DateTimeFormat(pattern = "MM-DD-YYYY")
    private LocalDate dateOfSubmission;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "leadTime")
    private int leadTime;
    
    @Column(name = "dateOfAdmission")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateOfAdmission;
    
    @Column(name = "endDate")
    @DateTimeFormat(pattern = "MM-DD-YYYY")
    private Date endDate;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carId")
    private Car car;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(name = "booking_user",
    joinColumns = @JoinColumn(name = "bookingId"),
    inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	public LocalDate getDateOfSubmission() {
		return dateOfSubmission;
	}

	public void setDateOfSubmission(LocalDate dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
}

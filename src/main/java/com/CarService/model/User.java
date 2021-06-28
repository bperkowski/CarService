package com.CarService.model;

import java.util.Date;
import java.util.Set;
import com.CarService.model.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "User")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
	@Column(name = "email")
    private String email;
	
	@Column(name = "password")
    private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column(name = "name")
    private String name;
    
	@Column(name = "surname")
	private String surname;

	@Column(name = "pesel")
    private String pesel;
    
    @Column(name = "nip")
    private String nip;
    
    @Column(name = "dateOfEmployment")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateOfEmployment;
    
    @Column(name = "reward")
    private float reward;
    
    @Column(name = "dateOfBirth")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    
    @Column(name = "adres")
    private String adres;
    
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    @Column(name = "position")
    private String position;
    
	@Column(name = "isActive")
    private int isActive;
	
	@Column(name = "activationCode")
	private String activationCode;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role role;
	
    @OneToMany(mappedBy="user") 
    private Set<Car> cars;
    
    @OneToMany(mappedBy = "user")
    private Set<Errand> errand;
    
    @ManyToMany(mappedBy = "user")
    private Set<Booking> booking;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public float getReward() {
		return reward;
	}

	public void setReward(float reward) {
		this.reward = reward;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public Set<Errand> getErrand() {
		return errand;
	}

	public void setErrand(Set<Errand> errand) {
		this.errand = errand;
	}

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

    
}

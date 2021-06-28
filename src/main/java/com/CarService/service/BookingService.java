package com.CarService.service;

import java.util.List;

import com.CarService.model.Booking;

public interface BookingService {
	
	public List<Booking> getAllCarReservations (int carId);
	
	public void saveBooking (Booking booking);
	
	public Booking getBooking(int bookingId);
	
	public void updateBooking(Booking booking);
	
	public List<Booking> getAllCustomerReservation (int customerId);
	
	public List<Booking> getAllCustomerReservationsWithStatus (int customerId, String status);
	
	public void deleteBooking(int bookingId);
	
	public List<Booking> getAllBooking();
	
	public List<Booking> getAllBookingWithStatus(String status);
	
}

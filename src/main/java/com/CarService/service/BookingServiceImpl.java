package com.CarService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarService.dao.BookingDao;
import com.CarService.model.Booking;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao bookingDao;

	@Override
	public List<Booking> getAllCarReservations(int carId) {
		return bookingDao.getAllCarReservations(carId);
	}
	
	@Override
	public void saveBooking (Booking booking) {
		bookingDao.saveBooking(booking);
	}
	
	@Override
	public Booking getBooking(int bookingId) {
		return bookingDao.getBooking(bookingId);
	}
	
	@Override
	public void updateBooking(Booking booking) {
		bookingDao.updateBooking(booking);
	}
	
	@Override
	public List<Booking> getAllCustomerReservation (int customerId) {
		return bookingDao.getAllCustomerReservation(customerId);
	}
	
	@Override
	public List<Booking> getAllCustomerReservationsWithStatus (int customerId, String status){
		return bookingDao.getAllCustomerReservationWithStatus(customerId, status);
	}
	
	@Override
	public void deleteBooking(int bookingId) {
		bookingDao.deleteBooking(bookingId);
	}
	
	@Override
	public List<Booking> getAllBooking() {
		return bookingDao.getAllBooking();
	}
	
	@Override
	public List<Booking> getAllBookingWithStatus(String status) {
		return bookingDao.getAllBookingWithStatus(status);
	}
}

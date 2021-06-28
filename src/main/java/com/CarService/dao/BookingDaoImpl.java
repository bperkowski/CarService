package com.CarService.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CarService.model.Booking;

@Repository
public class BookingDaoImpl implements BookingDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Booking> getAllCarReservations(int carId) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Booking> cq = cb.createQuery(Booking.class);
		Root<Booking> r = cq.from(Booking.class);
		cq.select(r).where(cb.equal(r.get("car").get("id"), carId));
		try{
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch (Exception e){
			return null;
		}
	}

	@Override
	public void saveBooking (Booking booking) {
		Session session = sessionFactory.getCurrentSession();
		session.save(booking);
	}
	
	@Override
	public Booking getBooking(int bookingId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Booking.class, bookingId);
	}
	
	@Override
	public void updateBooking(Booking booking) {
		Session session = sessionFactory.getCurrentSession();
		session.update(booking);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Booking> getAllCustomerReservation (int customerId) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Booking> cq = cb.createQuery(Booking.class);
		Root<Booking> r = cq.from(Booking.class);
		cq.select(r).where(cb.equal(r.join("user").get("id"), customerId));
		try{
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch (Exception e){
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Booking> getAllCustomerReservationWithStatus (int customerId, String status){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Booking> cq = cb.createQuery(Booking.class);
		Root<Booking> r = cq.from(Booking.class);
		cq.select(r).where(cb.equal(r.join("user").get("id"), customerId), 
				cb.equal(r.get("status"), status));
		try{
			Query tq = session.createQuery(cq);
			return tq.getResultList();}
		catch (Exception e) {
				return null;
		}
	}
	
	@Override
	public void deleteBooking(int bookingId) {
		Session session = sessionFactory.getCurrentSession();
		Booking booking = session.load(Booking.class, bookingId);
		session.delete(booking);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Booking> getAllBooking(){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Booking> cq = cb.createQuery(Booking.class);
		Root<Booking> r = cq.from(Booking.class);
		cq.select(r);
		try {
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Booking> getAllBookingWithStatus(String status) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Booking> cq = cb.createQuery(Booking.class);
		Root<Booking> r = cq.from(Booking.class);
		cq.select(r).where(cb.equal(r.get("status"), status));
		try {
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}

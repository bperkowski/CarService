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

import com.CarService.model.CarPart;

@Repository
public class CarPartDaoImpl implements CarPartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CarPart> getAvailableParts(){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CarPart> cq = cb.createQuery(CarPart.class);
		Root<CarPart> r = cq.from(CarPart.class);
		cq.select(r).where(cb.equal(r.get("availability"), 1));
		try {
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public CarPart getCarPart(int carPartId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(CarPart.class, carPartId);
	}
	
	@Override
	public void createCarPart(CarPart carPart) {
		Session session = sessionFactory.getCurrentSession();
		session.save(carPart);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CarPart> getCarParts(){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CarPart> cq = cb.createQuery(CarPart.class);
		Root<CarPart> r = cq.from(CarPart.class);
		cq.select(r);
		try {
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public void updateCarPart(CarPart carPart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(carPart);
	}
}

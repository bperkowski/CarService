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

import com.CarService.model.Car;

@Repository
public class CarDaoImpl implements CarDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Car> getCarListByUserId(int id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Car> cq = cb.createQuery(Car.class);
		Root<Car> r = cq.from(Car.class);
		cq.select(r)
			.where(cb.equal(r.get("user").get("id"), id));
		try{
			Query tq = session.createQuery(cq);
			return (List<Car>) tq.getResultList();
		} catch (Exception e) {
				return null;
		}
	}

	@Override
	public void addCar(Car car) {
		Session session = sessionFactory.getCurrentSession();
		session.save(car);
	}
	
	@Override
	public Car getCar(int carId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Car.class, carId);	
	}
	
	@Override
	public void updateCar(Car car) {
		Session session = sessionFactory.getCurrentSession();
		session.update(car);
	}

	@Override
	public void deleteCar(int carId) {
		Session session = sessionFactory.getCurrentSession();
		Car car = session.byId(Car.class).load(carId);
		session.delete(car);
	}
}

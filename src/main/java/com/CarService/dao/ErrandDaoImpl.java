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

import com.CarService.model.Errand;

@Repository
public class ErrandDaoImpl implements ErrandDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Errand createErrand(Errand errand) {
		Session session = sessionFactory.getCurrentSession();
		session.save(errand);
		return errand;
	}

	@Override
	public void updateErrand(Errand errand) {
		Session session = sessionFactory.getCurrentSession();
		session.update(errand);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Errand> getAllErrands() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Errand> cq = cb.createQuery(Errand.class);
		Root<Errand> r = cq.from(Errand.class);
		cq.select(r);
		try {
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public Errand getErrand(int errandId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Errand.class, errandId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Errand> getAllErrandsWithStatus(String status){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Errand> cq = cb.createQuery(Errand.class);
		Root<Errand> r = cq.from(Errand.class);
		cq.select(r).where(cb.equal(r.get("status"), status));
		try {
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}


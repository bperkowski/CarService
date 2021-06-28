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

import com.CarService.model.DetailsErrand;

@Repository
public class DetailsErrandDaoImpl implements DetailsErrandDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createDetailsErrand(DetailsErrand detailsErrand) {
		Session session = sessionFactory.getCurrentSession();
		session.save(detailsErrand);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<DetailsErrand> getAllDetailsErrandWithIdErrand(int errandId) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<DetailsErrand> cq = cb.createQuery(DetailsErrand.class);
		Root<DetailsErrand> r = cq.from(DetailsErrand.class);
		cq.select(r).where(cb.equal(r.get("errand").get("id"), errandId));
		try {
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
}

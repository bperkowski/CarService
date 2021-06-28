package com.CarService.dao;




import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CarService.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registryUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	@Override
	public User findUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root)
			.where(cb.equal(root.get("email"), email));
		try {
			Query tq = session.createQuery(cq);
			return (User)tq.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void updateUserActivation(int isActive, String activationCode) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaUpdate<User> update = criteriaBuilder.createCriteriaUpdate(User.class);
		Root<User> root = update.from(User.class);
		update.set(root.get("isActive"), isActive)
			.where(criteriaBuilder.equal(root.get("activationCode"), activationCode));
		Query query = session.createQuery(update);
		query.executeUpdate();
	}
	
	@Override
	public void updateUserData(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}
	
	@Override
	public User findUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUserWithRole(int roleId){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> r = cq.from(User.class);
		cq.select(r).where(cb.equal(r.join("role").get("id"), roleId));
		try{
			Query tq = session.createQuery(cq);
			return tq.getResultList();
		} catch (Exception e){
			return null;
		}
	}
}

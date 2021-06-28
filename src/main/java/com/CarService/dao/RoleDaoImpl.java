package com.CarService.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CarService.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Role getRoleById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Role.class, id);
	}
	
	

}

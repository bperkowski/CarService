package com.CarService.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarService.dao.RoleDao;
import com.CarService.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getRoleById(int id) {
		return roleDao.getRoleById(id);
	}

	
}

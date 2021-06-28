package com.CarService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.CarService.dao.UserDao;
import com.CarService.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void registryUser(User user, int roleId) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setIsActive(0);
		user.setRole(roleService.getRoleById(roleId));
		userDao.registryUser(user);
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}
	
	@Override
	public void updateUserActivation(int isActive, String activationCode) {
		userDao.updateUserActivation(isActive, activationCode);
	}
	
	@Override
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}
	
	@Override
	public void updateUserData(User user) {
		User updateUser = userDao.findUserById(user.getId());
		updateUser.setName(user.getName());
		updateUser.setSurname(user.getSurname());
		updateUser.setPesel(user.getPesel());
		updateUser.setNip(user.getNip());
		updateUser.setDateOfBirth(user.getDateOfBirth());
		updateUser.setDateOfEmployment(user.getDateOfEmployment());
		updateUser.setAdres(user.getAdres());
		updateUser.setPhoneNumber(user.getPhoneNumber());
		updateUser.setPosition(user.getPosition());
		updateUser.setReward(user.getReward());
		updateUser.setIsActive(user.getIsActive());
		userDao.updateUserData(updateUser);
	}
	
	@Override
	public List<User> getAllUserWithRole(int roleId){
		return userDao.getAllUserWithRole(roleId);
	}
}

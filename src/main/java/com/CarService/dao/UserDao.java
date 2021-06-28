package com.CarService.dao;

import java.util.List;

import com.CarService.model.User;

public interface UserDao {

	public void registryUser(User user);
	
	public User findUserByEmail(String email);
	
	public void updateUserActivation(int isActive, String activationCode);
	
	public void updateUserData(User user);
	
	public User findUserById(int id);
	
	public List<User> getAllUserWithRole(int roleId);
}

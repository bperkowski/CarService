package com.CarService.service;

import java.util.List;

import com.CarService.model.User;

public interface UserService {

	public void registryUser(User user, int roleId);
	
	public User findUserByEmail(String email);
	
	public void updateUserActivation(int isActive, String activationCode);
	
	public void updateUserData(User user);
	
	public User findUserById(int id);
	
	public List<User> getAllUserWithRole(int roleId);
}

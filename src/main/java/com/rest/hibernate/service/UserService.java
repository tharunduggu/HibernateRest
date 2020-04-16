package com.rest.hibernate.service;

import java.util.List;

import com.rest.hibernate.model.User;

public interface UserService {
	
	public void createUser(User user);
	
	public List<User> getUsers();
	
	public User getUserById(Integer id);
	
	public void delete(Integer id);
	
	public User updateUserById(User user);
		
}

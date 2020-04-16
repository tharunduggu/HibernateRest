package com.rest.hibernate.dao;

import java.util.List;

import com.rest.hibernate.model.User;

public interface UserDao {

	 public void addUser(User user);
     
	 public List<User> getUser();
     
	 public User findById(int id);
	 public void delete(int id);
	 
	 public User updateUser(User user);
}

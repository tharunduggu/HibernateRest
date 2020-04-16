package com.rest.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.hibernate.dao.UserDao;
import com.rest.hibernate.model.User;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;
	
	
	public void createUser(User user) {
		
		userDao.addUser(user);
		
	}


	public List<User> getUsers() {
		
		return userDao.getUser();
	}


	public User getUserById(Integer id) {
		
		return userDao.findById(id);
	}
	
	public void delete(Integer id) {
		
		userDao.delete(id);
		
	}
	
	public User updateUserById(User user) {
		userDao.updateUser(user);
		return user;
	}
}

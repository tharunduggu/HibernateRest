package com.rest.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rest.hibernate.model.User;
import com.rest.hibernate.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable int id) {
		System.out.println("Fetching User with id--- " + id);
		
		User user = userService.getUserById(id);
		System.out.println(user);
		return user;
	 }
	
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
	     userService.createUser(user);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/getUser/{id}").buildAndExpand(user.getId()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping(value="/delete/{id}")
	 public ResponseEntity<User> delete(@PathVariable("id") int id){
		 User user = userService.getUserById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.delete(id);
	 	return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	 
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		System.out.println("Fetching all Users  ");
		return userService.getUsers();
	}
	
	
	
}

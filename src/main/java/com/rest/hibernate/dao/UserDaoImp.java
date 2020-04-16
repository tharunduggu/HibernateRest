package com.rest.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.hibernate.model.User;

@Repository
public class UserDaoImp implements UserDao {

@Autowired
SessionFactory sessionFactory;

	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);	
	}


	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<User> getUser() {
		System.out.println("Dao request recieved ");
		Session session = sessionFactory.getCurrentSession();
		String hqlString = "From User";
		Query query = session.createQuery(hqlString);
		return query.list();
//		Session session = sessionFactory.getCurrentSession();
//		return session.createCriteria(User.class).list();
	}


	public User findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
	
	

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = findById(id);
		session.delete(user);
	}
	
	public User updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		System.out.println(user.toString());
		return user;
	}

}

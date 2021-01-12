package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dao.UserDao;
import com.assignment.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
 private UserDao userDao;

	public List<User> getAllUsers() {
		List<User> user = (List<User>) userDao.findAll();
		return user;
	}

	@Override
	public void insertUser(User user) {
		userDao.save(user);
		
	}


	

}
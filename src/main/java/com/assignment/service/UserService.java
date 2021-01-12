package com.assignment.service;

import java.util.List;

import com.assignment.model.User;

public interface UserService {
	List<User> getAllUsers();
	void insertUser(User user);
}
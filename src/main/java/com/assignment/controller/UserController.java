package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.User;
import com.assignment.service.UserService;

@RestController
public class UserController {

	@Autowired
		UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {

		return userService.getAllUsers();

	}
	
	@RequestMapping(value = "/insertuser", method = RequestMethod.POST)
	public void insertEmployee(@RequestBody User user) {
		userService.insertUser(user);

}
	@GetMapping("/fun")
    public String fun(){return "Remote reloading is fun! This should reload too yes";}
	@GetMapping("/docker")
    public String docker(){return "Hi from Docker container this is Dhruv Mathur good evening";}
}

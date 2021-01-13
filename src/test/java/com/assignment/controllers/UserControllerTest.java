package com.assignment.controllers;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.assignment.controller.UserController;
import com.assignment.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	
	@Test
	public void funTest() throws Exception {

		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fun");

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		assertNull("null");
	}
	
	@Test
	public void dockerTest() throws Exception {

		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/docker");

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

	
	@Test
	public void usersTest() throws Exception {

		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

}

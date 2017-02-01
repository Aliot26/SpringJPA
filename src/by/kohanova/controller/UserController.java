package by.kohanova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import by.kohanova.model.User;
import by.kohanova.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/hello/", method = RequestMethod.GET)
	public String hello() {
		String hello = "Hello Spring! It was written by Olga";
		return hello;
	}
	
	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> listOfUsers = userService.findAll();			
		return listOfUsers;
	}

}

package by.kohanova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import by.kohanova.model.User;
import by.kohanova.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller is used for processing
 * requests and return responses
 * to DispatcherServlet
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * Is used for defining incoming request url with part "/hello/"
	 * @return greeting string
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		String hello = "Hello Spring! It was written by Olga";
		return hello;
	}
	
	/**
	 * Is used for getting list of users
	 * @return list of users
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> listOfUsers = userService.findAll();			
		return listOfUsers;
	}
	
	/**
	 * Is used for getting user by name
	 * @param name - user name
	 * @return User object
	 */
	@RequestMapping(value = "/users/{name}")
	public User getUserByName(@PathVariable String name) {
		try {
			logger.info("Start getUserByName method: " + name);
			User user = userService.findUserByName(name);
			return user;

		} catch (NullPointerException e) {
			logger.error("Exception occured in getUserByName " + e.getLocalizedMessage());
			return null;
		}
	}

}

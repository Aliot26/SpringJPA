package by.kohanova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public ModelAndView getdata() {
		List<User> list = userService.findAll();
		StringBuilder resultString = new StringBuilder();
		for (User user : list) {
			resultString.append(user.getId() + " : " + user.getName() + "</br>");
		}

		ModelAndView model = new ModelAndView("index");
		model.addObject("result", resultString);
		return model;
	}

	@RequestMapping(value = "/users/{name}")
	public ModelAndView getUserByName(@PathVariable String name) {
		try {
			logger.info("Start getUserByName method: " + name);
			User user = userService.findUserByName(name);
			ModelAndView model = new ModelAndView("index");
			model.addObject("result", user.getName());
			return model;

		} catch (NullPointerException e) {
			logger.error("Exception occured in getUserByName " + e.getLocalizedMessage());
			return null;
		}
	}
}

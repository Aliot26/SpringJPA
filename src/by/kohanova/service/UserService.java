package by.kohanova.service;

import by.kohanova.model.User;
import java.util.List;

public interface UserService {
	/**
	 * Method to return list of all users
	 * 
	 * @return list of users
	 */
	List<User> findAll();

	/**
	 * Method to return user by user name
	 * 
	 * @param name
	 * @return user entity
	 */
	User findUserByName(String name);
}

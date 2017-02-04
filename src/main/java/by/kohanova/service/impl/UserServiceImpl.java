package by.kohanova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kohanova.model.User;
import by.kohanova.repository.UserRepository;
import by.kohanova.service.UserService;

/**
 * UserService interface implementation
 */
@Service()
public class UserServiceImpl implements UserService {

	/**
	 * Injects UserRepository bean
	 */
	@Autowired
	private final UserRepository userRepository;

	/**
	 * Constructor for UserRepository setting
	 * @param userRepository
	 */
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByName(String name) {
		return userRepository.findUserByName(name);
	}
}
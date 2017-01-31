package by.kohanova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kohanova.model.User;
import by.kohanova.repository.UserRepository;

@Service()
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository userRepository;

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
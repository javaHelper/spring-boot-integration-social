package com.howtodoinjava.redis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.redis.model.User;
import com.howtodoinjava.redis.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}

	@Override
	public User findUserByUserId(String userId) {
		Optional<User> optionalUser = userRepository.findByUserId(userId);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
}

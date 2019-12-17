package com.howtodoinjava.redis.service;

import java.util.List;

import com.howtodoinjava.redis.model.User;

public interface UserService {
	List<User> findAllUsers();
	User findUserByUserId(String userId);
}

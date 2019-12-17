package com.howtodoinjava.redis.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.howtodoinjava.redis.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findByUserId(String id);
}

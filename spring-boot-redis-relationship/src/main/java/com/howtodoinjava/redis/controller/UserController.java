package com.howtodoinjava.redis.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.redis.model.Category;
import com.howtodoinjava.redis.model.User;
import com.howtodoinjava.redis.service.CategoryService;
import com.howtodoinjava.redis.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/api/users")
	public ResponseEntity<List<User>> findUsers(){
		List<User> users = userService.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	
	@GetMapping("/api/user/{user-id}")
	public ResponseEntity<User> findUserByUserId(@PathVariable("user-id") String userId){
		User u = userService.findUserByUserId(userId);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@GetMapping("/api/categories")
	public ResponseEntity<List<Category>> findCategories(){
		List<Category> categories = categoryService.findAllCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
}

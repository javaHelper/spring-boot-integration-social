package com.howtodoinjava.redis.service;

import java.util.List;

import com.howtodoinjava.redis.model.Category;

public interface CategoryService {
	List<Category> findAllCategories();
}

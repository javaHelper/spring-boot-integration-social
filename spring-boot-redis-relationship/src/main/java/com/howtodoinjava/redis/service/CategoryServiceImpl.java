package com.howtodoinjava.redis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.redis.model.Category;
import com.howtodoinjava.redis.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAllCategories() {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach(category -> categories.add(category));
		return categories;
	}
}

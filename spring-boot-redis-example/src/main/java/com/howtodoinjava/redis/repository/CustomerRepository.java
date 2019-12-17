package com.howtodoinjava.redis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.howtodoinjava.redis.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByFirstName(String firstName);
}

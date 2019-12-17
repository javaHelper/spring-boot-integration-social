package com.howtodoinjava.redis.service;

import java.util.List;

import com.howtodoinjava.redis.model.Customer;

public interface CustomerService {
	Customer findCustomerById(Long customerId);
	List<Customer> findCustomerByFirstName(String firstName);
}

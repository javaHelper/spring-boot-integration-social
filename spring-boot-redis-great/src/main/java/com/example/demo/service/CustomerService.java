package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;


public interface CustomerService {
	List<Customer> findByAccountsId(Long accountId);
	Customer findByCustomerId(Long customerId);
}

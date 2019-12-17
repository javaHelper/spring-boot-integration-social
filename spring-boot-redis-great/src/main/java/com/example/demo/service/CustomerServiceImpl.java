package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findByAccountsId(Long accountId) {
		return customerRepository.findByAccountsId(accountId);
	}

	@Override
	public Customer findByCustomerId(Long customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		return null;
	}
}

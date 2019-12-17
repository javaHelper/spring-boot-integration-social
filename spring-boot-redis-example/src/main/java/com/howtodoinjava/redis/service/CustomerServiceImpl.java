package com.howtodoinjava.redis.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.redis.model.Customer;
import com.howtodoinjava.redis.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer findCustomerById(@NotBlank Long customerId) {
		Optional<Customer> optionalCust = customerRepository.findById(customerId);
		if (optionalCust.isPresent()) {
			return optionalCust.get();
		}
		return null;
	}

	@Override
	public List<Customer> findCustomerByFirstName(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}
}

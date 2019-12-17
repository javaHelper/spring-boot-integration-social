package com.howtodoinjava.redis.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.redis.model.Customer;
import com.howtodoinjava.redis.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/api/customer/{customer-id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("customer-id") @NotBlank Long customerId){
		Customer customer = customerService.findCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	
	@GetMapping("/api/customer/first-name/{first-name}")
	public ResponseEntity<List<Customer>> findCustomerByFirstName(@PathVariable("first-name") @NotBlank String firstName){
		List<Customer> customers = customerService.findCustomerByFirstName(firstName);
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}

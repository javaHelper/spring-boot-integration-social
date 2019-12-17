package com.example.demo.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "Find Customer By account-id", nickname = "Find Customer By account-id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping("/api/customers/account/{account-id}")
	public ResponseEntity<List<Customer>> findCustomerByAccId(@PathVariable("account-id") @NotBlank String accountId){
		List<Customer> customers = customerService.findByAccountsId(Long.valueOf(accountId));
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Find Customer By customer-id", nickname = "Find Customer By customer-id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping("/api/customers/{customer-id}")
	public ResponseEntity<Customer> findByCustomerId(@PathVariable("customer-id") @NotBlank String customerId){
		Customer customer = customerService.findByCustomerId(Long.valueOf(customerId));
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
}

package com.example.demo.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

	@ApiOperation(value = "Find Tx By id", nickname = "Find Tx By id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping("/api/tx/{id}")
	public ResponseEntity<Transaction> findCustomerByAccId(@PathVariable("id") @NotBlank String id){
		Transaction tx = transactionService.findById(Long.valueOf(id));
		return new ResponseEntity<>(tx, HttpStatus.OK);
	}

	@ApiOperation(value = "Find Tx From Account id", nickname = "Find Tx From Account id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping("api/from/{accountId}")
	public ResponseEntity<List<Transaction>> findByFromAccountId(Long accountId) {
		List<Transaction> txs = transactionService.findByFromAccountId(accountId);
		return new ResponseEntity<>(txs, HttpStatus.OK);
	}

	@ApiOperation(value = "Find Tx From Account id", nickname = "Find Tx From Account id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "200"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping("api/to/{accountId}")
	public ResponseEntity<List<Transaction>> findByToAccountId(Long accountId) {
		List<Transaction> txs = transactionService.findByToAccountId(accountId);
		return new ResponseEntity<>(txs, HttpStatus.OK);
	}

}

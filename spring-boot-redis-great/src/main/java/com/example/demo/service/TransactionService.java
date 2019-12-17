package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Transaction;

public interface TransactionService {
	Transaction findById(Long id);
	List<Transaction> findByFromAccountId(Long accountId);
	List<Transaction> findByToAccountId(Long accountId);
}

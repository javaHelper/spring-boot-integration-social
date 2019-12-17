package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;


@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Transaction findById(Long id) {
		Optional<Transaction> optTx = transactionRepository.findById(id);
		if(optTx.isPresent()) {
			return optTx.get();
		}
		return null;
	}

	@Override
	public List<Transaction> findByFromAccountId(Long accountId) {
		return transactionRepository.findByFromAccountId(accountId);
	}

	@Override
	public List<Transaction> findByToAccountId(Long accountId) {
		return transactionRepository.findByToAccountId(accountId);
	}
}

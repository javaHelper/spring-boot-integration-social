package com.example.demo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.model.Transaction;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TransactionRepository;

@SpringBootApplication
public class SpringBootRedisApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer(1L, "80010121098", "John Smith");
        customer.addAccount(new Account(1L, "1234567890", 2000));
        customer.addAccount(new Account(2L, "1234567891", 4000));
        customer.addAccount(new Account(3L, "1234567892", 6000));
        customerRepository.save(customer);
        
        Transaction t1 = new Transaction(1L, 1000, new Date(), 20L, 40L);
        Transaction t2 = new Transaction(2L, 1000, new Date(), 20L, 40L);
        Transaction t3 = new Transaction(3L, 1000, new Date(), 20L, 40L);
        Transaction t4 = new Transaction(4L, 1000, new Date(), 20L, 40L);
        transactionRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}

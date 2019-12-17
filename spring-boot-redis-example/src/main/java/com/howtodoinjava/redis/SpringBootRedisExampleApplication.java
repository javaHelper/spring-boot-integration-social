package com.howtodoinjava.redis;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.howtodoinjava.redis.model.Customer;
import com.howtodoinjava.redis.repository.CustomerRepository;

@SpringBootApplication
public class SpringBootRedisExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisExampleApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		Customer c1 = Customer.builder().id(1L).firstName("John").lastName("Doe").birthdate(LocalDateTime.now()).build();
		Customer c2 = Customer.builder().id(2L).firstName("Mike").lastName("Tushman").birthdate(LocalDateTime.now()).build();
		Customer c3 = Customer.builder().id(3L).firstName("Peter").lastName("Kerr").birthdate(LocalDateTime.now()).build();
		Customer c4 = Customer.builder().id(4L).firstName("Victoria").lastName("Johnston").birthdate(LocalDateTime.now()).build();
		customerRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
	}

}

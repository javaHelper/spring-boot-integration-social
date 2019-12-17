package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;

@Data
@RedisHash("customer")
public class Customer {
	@Id
	private Long id;
	@Indexed
	private String externalId;
	private String name;
	private List<Account> accounts = new ArrayList<>();

	public Customer(Long id, String externalId, String name) {
		this.id = id;
		this.externalId = externalId;
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}
}
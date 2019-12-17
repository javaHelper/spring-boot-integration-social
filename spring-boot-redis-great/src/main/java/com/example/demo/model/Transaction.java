package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("transaction")
public class Transaction {
	@Id
	private Long id;
	private int amount;
	private Date date;
	@Indexed
	private Long fromAccountId;
	@Indexed
	private Long toAccountId;
}
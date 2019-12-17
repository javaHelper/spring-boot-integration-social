package com.howtodoinjava.redis.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@RedisHash(value="customer")
public class Customer {
	@Id
	private Long id;
	@Indexed
	private String firstName;
	private String lastName;
	private LocalDateTime birthdate;
}

package com.howtodoinjava.redis.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("users")
public class User {
    @Id
    @Indexed
    private String userId;
    private String firstName;
    private String emailId;
    private List<Category> categories;
}
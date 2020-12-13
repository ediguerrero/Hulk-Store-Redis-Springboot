package com.example.demo.config;

import com.example.demo.entityes.Product;
import com.example.demo.entityes.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
public class RedisConfiguration {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() { return new JedisConnectionFactory(); }

	@Bean
	RedisTemplate<String, User> redisTemplateUser(){
		final RedisTemplate<String, User> redis=new RedisTemplate<>();
		redis.setConnectionFactory(jedisConnectionFactory());

		return redis;
	}
	@Bean
	RedisTemplate<String, Product> redisTemplateProduct(){
		final RedisTemplate<String, Product> redis=new RedisTemplate<>();
		redis.setConnectionFactory(jedisConnectionFactory());

		return redis;
	}
}

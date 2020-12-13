package config;

import entityes.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
public class RedisConfiguration {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() { return new JedisConnectionFactory(); }

	@Bean
	RedisTemplate<String, User> redisTemplate(){
		final RedisTemplate<String, User> redis=new RedisTemplate<>();
		redis.setConnectionFactory(jedisConnectionFactory());

		return redis;
	}
}

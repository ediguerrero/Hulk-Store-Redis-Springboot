package com.example.demo.repository;

import com.example.demo.entityes.Product;
import com.example.demo.entityes.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class StoreRepository implements RedisRepository{
    private static final String KEY= "Product";
    private RedisTemplate<String, Product> redisTemplate;
    private HashOperations hashOperations;

    public StoreRepository(RedisTemplate<String, Product> redisTemplate) {this.redisTemplate = redisTemplate;}
    @PostConstruct
    private void init() { hashOperations = redisTemplate.opsForHash(); }

    @Override
    public Map<String, User> finAllUsers() {
        return null;
    }

    @Override
    public Map<String, Product> finAllProducts() throws Exception{
        return 	hashOperations.entries(KEY);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public String saveUser(User user) {
        return null;
    }

    @Override
    public String deleteUserByEmail(String email) {
        return null;
    }

    @Override
    public String saveProduct(Product product) throws Exception{
        String name= product.getName();
        hashOperations.put(KEY, name, product);
        return name;
    }

    @Override
    public Product findProductByName(String name) throws Exception {
        return (Product) hashOperations.get(KEY, name);
    }

    @Override
    public void updateProduct(Product product)throws Exception {
         hashOperations.put(KEY, product.getName(), product);
    }

    @Override
    public void deleteProductByName(String name)throws Exception {
        hashOperations.delete(KEY, name);
    }
}

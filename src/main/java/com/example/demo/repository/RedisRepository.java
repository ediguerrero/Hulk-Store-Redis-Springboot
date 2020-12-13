package com.example.demo.repository;

import com.example.demo.entityes.Product;
import com.example.demo.entityes.User;

import java.util.Map;

public interface RedisRepository {
    Map<String, User> finAllUsers();
    Map<String, Product> finAllProducts() throws Exception;
    User findByEmail(String email);
    String saveUser(User user);
    String deleteUserByEmail(String email);
    String saveProduct(Product product) throws Exception;
    Product findProductByName(String name) throws Exception;
    Product updateProduct(Product product);
    void deleteProductByName(String name) throws Exception;

}

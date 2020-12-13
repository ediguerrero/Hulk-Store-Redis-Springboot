package com.example.demo.controller;

import com.example.demo.entityes.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.StoreRepository;

import java.util.Map;

@RestController
@RequestMapping("/")
public class StoreREST {
    private StoreRepository storeRepository;

    public StoreREST(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping("/Products")
    public Map<String, Product> findAllProducts(){	return storeRepository.finAllProducts();}

}

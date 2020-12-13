package com.example.demo.controller;

import com.example.demo.entityes.Product;
import com.example.demo.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.StoreRepository;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/")
public class StoreREST {
    private StoreRepository storeRepository;

    public StoreREST(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping("/Products")
    public GenericResponse<Map<String, Product>> findAllProducts() {
        try {
            return new GenericResponse<>(storeRepository.finAllProducts());
        } catch (Exception e) {
            return  new GenericResponse<>(Response.Status.NO_CONTENT,e.getMessage());
        }
    }
    @GetMapping("/Product/{name}")
    public GenericResponse<Product> findProductByName(@PathVariable String name) {
        try {
            return new GenericResponse<>(storeRepository.findProductByName(name));
        } catch (Exception e) {
           return  new GenericResponse<>(Response.Status.NOT_FOUND,e.getMessage());
        }
    }
    @PostMapping("/createProduct")
    public GenericResponse<String> createProduct(@RequestBody Product product) {
        try {
            storeRepository.saveProduct(product);
            return new GenericResponse<>("producto " + product.getName() + " guardado");
        } catch (Exception e) {
            return  new GenericResponse<>(Response.Status.CONFLICT,e.getMessage());
        }

    }

    @DeleteMapping("/Products/{name}")
    public GenericResponse<String> deleteProductByName(@PathVariable String name) {
        try {
            storeRepository.deleteProductByName(name);
            return new GenericResponse<>("producto " + name + " eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            return new GenericResponse<>(Response.Status.CONFLICT,e.getMessage());
        }

    }

}

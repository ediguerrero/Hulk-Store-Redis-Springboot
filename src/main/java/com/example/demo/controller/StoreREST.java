package com.example.demo.controller;

import com.example.demo.entityes.Product;
import com.example.demo.utils.GenericResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.StoreRepository;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

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
            return new GenericResponse<>(Response.Status.NO_CONTENT, e.getMessage());
        }
    }
    @GetMapping("/formulario")
    public String getformulario(Model model) throws Exception {
      model.addAttribute("products", storeRepository.finAllProducts());
        return "formulario1";

    }


    @GetMapping("/Product/{name}")
    public GenericResponse<Product> findProductByName(@PathVariable String name) {
        try {
            return new GenericResponse<>(storeRepository.findProductByName(name));
        } catch (Exception e) {
            return new GenericResponse<>(Response.Status.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/createProduct")
    public GenericResponse<String> createProduct(@RequestBody Product product) {
        try {
            Product product1 = storeRepository.findProductByName(product.getName());
            if(Objects.nonNull(product1)){
                return new GenericResponse<>(Response.Status.CONFLICT,"el producto "+product1.getName()+" ya existe, aumente el stock");
            }
            else{
            storeRepository.saveProduct(product);
            return new GenericResponse<>("producto " + product.getName() + " guardado");
            }
        } catch (Exception e) {
            return new GenericResponse<>(Response.Status.CONFLICT, e.getMessage());
        }

    }

    @DeleteMapping("/Products/{name}")
    public GenericResponse<String> deleteProductByName(@PathVariable String name) {
        try {
            storeRepository.deleteProductByName(name);
            return new GenericResponse<>("producto " + name + " eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            return new GenericResponse<>(Response.Status.CONFLICT, e.getMessage());
        }


    }

    @PutMapping("sellProduct/{name}/{amountToSell}")
    public GenericResponse<String> sellProduct(@PathVariable String name, @PathVariable int amountToSell) {
        try {
            Product product1 = storeRepository.findProductByName(name);
            if (Objects.isNull(product1)) {
                return new GenericResponse<>(Response.Status.NOT_FOUND, "el producto no existe en la base de datos");
            } else {
                if (product1.getAmount() == 0) {
                    return new GenericResponse<>("el producto " + product1.getName() + "No contiene stock");
                }
                if (product1.getAmount() >= amountToSell) {
                    int sell = product1.getAmount() - amountToSell;
                    product1.setAmount(sell);
                    storeRepository.updateProduct(product1);
                    return new GenericResponse<>("producto " + product1.getName() + " vendido con exito la actidad actual es de " + sell);
                } else {
                    return new GenericResponse<>(Response.Status.CONFLICT, "la cantidad para vender no es correcta");
                }

            }
        } catch (Exception e) {
            return new GenericResponse<>(Response.Status.CONFLICT, e.getMessage());
        }

    }

    @PutMapping("addStock/{name}/{amountToAdd}")
    public GenericResponse<String> addStock(@PathVariable String name, @PathVariable int amountToAdd) {
        try {
            Product product1 = storeRepository.findProductByName(name);
            if (Objects.isNull(product1)) {
                return new GenericResponse<>(Response.Status.NOT_FOUND, "el producto no existe en la base de datos");
            } else {

                int add = product1.getAmount() + amountToAdd;
                product1.setAmount(add);
                storeRepository.updateProduct(product1);
                return new GenericResponse<>("Al producto " + product1.getName() + " se le ha aumentado el stock, la cantidad actual es de  " + product1.getAmount());

            }
        } catch (Exception e) {
            return new GenericResponse<>(Response.Status.CONFLICT, e.getMessage());
        }

    }
}

package com.example.demo.entityes;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    private long dateSell;
    private String idCart;
    private List<Product> products;

    public long getDateSell() {
        return dateSell;
    }

    public void setDateSell(long dateSell) {
        this.dateSell = dateSell;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

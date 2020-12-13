package com.example.demo.entityes;

import java.io.Serializable;

public class Product implements Serializable {
    private int amount;
    private double price;
    private String name;



    public Product(String name, int amount, double price) {
        this.amount = amount;
        this.name = name;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

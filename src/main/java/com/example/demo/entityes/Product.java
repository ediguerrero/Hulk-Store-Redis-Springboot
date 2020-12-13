package com.example.demo.entityes;

import java.io.Serializable;

public class Product implements Serializable {
    private int amount;
    private double price;
    private String name;
    private String type;


    public Product(String name, int amount, double price, String type) {
        this.amount = amount;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getCantidad() {
        return amount;
    }

    public void setCantidad(int cantidad) {
        this.amount = cantidad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

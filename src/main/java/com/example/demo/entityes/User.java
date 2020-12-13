package com.example.demo.entityes;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String UserName;
    private String password;
    private String fullName;
    private String email;
    private List<Cart> carts;


    public User(String userName, String password, String fullName, String email, List<Cart> carts) {
        UserName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.carts = carts;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}

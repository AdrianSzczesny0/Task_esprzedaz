package com.sellingo.Models;

public class User {
    public final String email;
    public final String password;
    public final String rePassword;

    public User() {
        long timestamp = System.currentTimeMillis();
        this.email = "test" + timestamp + "@example.com";
        this.password = "P@ss" + timestamp;
        this.rePassword = this.password;
    }
}

package com.mvp.model;

/**
 * Created by atiq on 23/10/17.
 */

public class User {
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String username;
    private String password;
}

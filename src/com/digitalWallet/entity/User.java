package com.digitalWallet.entity;

import java.util.UUID;

public class User {
    private String username;
    private String id;

    public User(String username){
        this.id= UUID.randomUUID().toString();
        this.username=username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }
}

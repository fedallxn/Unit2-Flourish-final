package com.FaithDall.Flourish_Unit_2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;
    private String petType;
    private Instant createdAt;

    public User() {
    }

    public User(String username, String password, String petType) {
        this.username = username;
        this.password = password;
        this.petType = petType;
    }

    public int getUserIdd() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPetType() {
        return petType;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
}


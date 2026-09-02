package com.FaithDall.Flourish_Unit_2.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;
    private String petType;
    private Instant createdAt;

    //since there are many plants to one user, it's better to represent plants in a list
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Plant> plants;

    //sets the timestamp automatically when a user object is created, so it doesn't need to be set manually each time
    public User() {
        this.createdAt = Instant.now();
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

    public Instant getCreatedAt() { return createdAt; }

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


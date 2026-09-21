package com.FaithDall.Flourish_Unit_2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int plantId;
    private String nickname;
    private Instant createdAt;

    //we don't need the users information, just the species information
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Species species;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plant", orphanRemoval = true)
    private List<WateringLog> wateringLogs;

    //sets the timestamp automatically when a user object is created, so it doesn't need to be set manually each time
    @PrePersist
    public void onCreate() {
        this.createdAt = Instant.now();
    }

    //again, still need an empty one
    public Plant() {
    }

    public Plant(String nickname) {
        this.nickname = nickname;
    }

    public int getPlantId() {
        return plantId;
    }

    public String getNickname() {
        return nickname;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public Species getSpecies() { return species; }

    //realized I needed a setter for the user because I need to be able to assign a user to the plant when its added
    public void setUser(User user) { this.user = user; }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}

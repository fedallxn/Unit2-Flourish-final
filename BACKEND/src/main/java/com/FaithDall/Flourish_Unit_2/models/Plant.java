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
    //needs to mimic what the front end looks like which includes the plant image before species data is loaded
    @Column(name = "plant_image_url")
    private String plantImageURL;
    //needed a reference point for react
    private String speciesName;
    private Instant createdAt;

    //we don't need the users information, just the species information
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    //I'm changing this back to Lazy because when I was using Eager it was causing triplicates (bc I have 3 users)
    @ManyToOne(fetch = FetchType.LAZY)
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

    public String getPlantImageURL() { return plantImageURL; }

    public String getSpeciesName() { return speciesName; }

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

    public void setPlantImageURL(String plantImageURL) { this.plantImageURL = plantImageURL; }

    public void setSpeciesName(String speciesName) { this.speciesName = speciesName; }

    public void setSpecies(Species species) {
        this.species = species;
    }
}

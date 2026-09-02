package com.FaithDall.Flourish_Unit_2.models;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plant", orphanRemoval = true)
    private List<WateringLog> wateringLogs;

    //sets the timestamp automatically when a user object is created, so it doesn't need to be set manually each time
    public Plant() {
        this.createdAt = Instant.now();
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

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

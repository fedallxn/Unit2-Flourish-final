package com.FaithDall.Flourish_Unit_2.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "messages")
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;
    private String name;
    private String email;
    private String category;
    private String userMessage;
    private Instant createdAt;

    //createdAt kept coming back null in POSTMAN, found this annotation that prevents SpringBoot from overwriting my no-arg constructor
    //and sets the createdAt field right before the entity is saved
    @PrePersist
    public void ContactMessage() {
        this.createdAt = Instant.now();
        //System.out.println("No-arg constructor called! createdAt: " + this.createdAt);
    }

    public ContactMessage(String name, String email, String category, String userMessage) {
        this.name = name;
        this.email = email;
        this.category = category;
        this.userMessage = userMessage;
    }

    //again, no setters because this is just a record like the waterlogs, all fields are immutable.

    public int getMessageId() {
        return messageId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCategory() {
        return category;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}

package com.FaithDall.Flourish_Unit_2.models;

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

    public ContactMessage() {
        this.createdAt = Instant.now();
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

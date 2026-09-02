package com.FaithDall.Flourish_Unit_2.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "wateringLogs")
public class WateringLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;
    //unlike Instant, LocalDate just returns the date without a time attached to it
    private LocalDate wateredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plant plant;

    public WateringLog() {
        this.wateredAt = LocalDate.now();
    }

    //no setters because I want these to be immutable!
    public int getLogId() {
        return logId;
    }

    public LocalDate getWateredAt() {
        return wateredAt;
    }

    public Plant getPlant() {
        return plant;
    }
}

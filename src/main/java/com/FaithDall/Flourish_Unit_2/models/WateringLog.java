package com.FaithDall.Flourish_Unit_2.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "wateringLogs")
public class WateringLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;
    private Instant wateredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plant plant;
}

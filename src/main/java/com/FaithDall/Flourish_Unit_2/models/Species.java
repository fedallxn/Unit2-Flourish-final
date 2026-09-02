package com.FaithDall.Flourish_Unit_2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int speciesId;
    private String commonName;
    private String scientificName;
    private int wateringFrequency;
    private String lightRequirement;
    private boolean isToxic;
    private String careInfo;
    private String plantImage;

    public Species() {
    }
}

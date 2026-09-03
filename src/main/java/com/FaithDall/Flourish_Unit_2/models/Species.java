package com.FaithDall.Flourish_Unit_2.models;

import jakarta.persistence.*;

import java.util.List;

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
    private String plantImageURL;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "species", orphanRemoval = true)
    private List<Plant> plants;

    public Species() {
    }

    public Species(
            //changed to vertical view since there are so many fields!
            String commonName,
            String scientificName,
            int wateringFrequency,
            String lightRequirement,
            boolean isToxic,
            String careInfo,
            String plantImageURL
    ) {
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.wateringFrequency = wateringFrequency;
        this.lightRequirement = lightRequirement;
        this.isToxic = isToxic;
        this.careInfo = careInfo;
        this.plantImageURL = plantImageURL;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public String getLightRequirement() {
        return lightRequirement;
    }

    public boolean isToxic() {
        return isToxic;
    }

    public String getCareInfo() {
        return careInfo;
    }

    public String getPlantImageURL() {
        return plantImageURL;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setWateringFrequency(int wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public void setLightRequirement(String lightRequirement) {
        this.lightRequirement = lightRequirement;
    }

    public void setCareInfo(String careInfo) {
        this.careInfo = careInfo;
    }

    public void setPlantImageURL(String plantImageURL) {
        this.plantImageURL = plantImageURL;
    }
}

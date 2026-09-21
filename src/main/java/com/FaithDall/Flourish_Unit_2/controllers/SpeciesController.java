package com.FaithDall.Flourish_Unit_2.controllers;

import com.FaithDall.Flourish_Unit_2.models.Species;
import com.FaithDall.Flourish_Unit_2.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("speciesInfo")
public class SpeciesController {
    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping("{commonName}")
    public Species getSpeciesInfo(@PathVariable String commonName) {
        return speciesRepository.findByCommonName(commonName);
    }

    @PostMapping
    public Species addSpecies(@RequestBody Species newSpecies) {
        return speciesRepository.save(newSpecies);
    }

    @PutMapping("{speciesId}")
    public ResponseEntity<Object> updateSpeciesInfo(@PathVariable int speciesId, @RequestBody Species updatedSpecies) {
        Species currentSpecies = speciesRepository.findById(speciesId).orElse(null);
        if (currentSpecies == null) {
            return ResponseEntity.status(404).body("Species not found.");
        } else {
            currentSpecies.setWateringFrequency(updatedSpecies.getWateringFrequency());
            currentSpecies.setLightRequirement(updatedSpecies.getLightRequirement());
            currentSpecies.setCareInfo(updatedSpecies.getCareInfo());
            currentSpecies.setPlantImageURL(updatedSpecies.getPlantImageURL());
            return ResponseEntity.ok(speciesRepository.save(currentSpecies));
        }
    }
}

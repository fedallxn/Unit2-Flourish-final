package com.FaithDall.Flourish_Unit_2.controllers;

import com.FaithDall.Flourish_Unit_2.models.Plant;
import com.FaithDall.Flourish_Unit_2.models.Species;
import com.FaithDall.Flourish_Unit_2.models.User;
import com.FaithDall.Flourish_Unit_2.repositories.PlantRepository;
import com.FaithDall.Flourish_Unit_2.repositories.SpeciesRepository;
import com.FaithDall.Flourish_Unit_2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("users/{userId}/plants")
public class PlantController {
    @Autowired
    private PlantRepository plantRepository;
    //had to inject another repository since I need to query the database for the user as well
    @Autowired
    private UserRepository userRepository;
    //reinjecting the species controller again, because I need the to pull species information when the user adds a plant
    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping
    public List<Plant> getUsersPlants(@PathVariable int userId) {
        return plantRepository.findByUserUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Object> addPlant(@PathVariable int userId, @RequestBody Plant plant) {
        User plantOwner = userRepository.findById(userId).orElse(null);
        if (plantOwner == null) {
            return ResponseEntity.status(404).body("No owner found.");
        }
        Species addedSpecies = speciesRepository.findByCommonName(plant.getSpeciesName());
        if (addedSpecies == null) {
            return ResponseEntity.status(404).body("No Species found.");
        }
        plant.setUser(plantOwner);
        plant.setSpecies(addedSpecies);
        plant.setPlantImageURL(addedSpecies.getPlantImageURL());
        return ResponseEntity.ok(plantRepository.save(plant));
    }

    @PutMapping("{plantId}")
    public ResponseEntity<Object> updatePlant(@PathVariable int userId, @PathVariable int plantId, @RequestBody Plant plant) {
        Plant currentPlant = plantRepository.findById(plantId).orElse(null);
        if (currentPlant == null) {
            return ResponseEntity.status(404).body("Plant not found.");
        } else {
            User currentUser = userRepository.findById(userId).orElse(null);
            if (currentUser == null) {
                return ResponseEntity.status(404).body("User not found.");
            } else {
                if (!currentPlant.getUser().equals(currentUser)) {
                    return ResponseEntity.status(403).body("Not authorized!");
                } else {
                    currentPlant.setNickname(plant.getNickname());
                    return ResponseEntity.ok(plantRepository.save(currentPlant));
                }
            }
        }
    }

    @DeleteMapping("{plantId}")
    public ResponseEntity<Object> deletePlant(@PathVariable int userId, @PathVariable int plantId) {
        Plant currentPlant = plantRepository.findById(plantId).orElse(null);
        if (currentPlant == null) {
            return ResponseEntity.status(404).body("Plant not found.");
        } else {
            User currentUser = userRepository.findById(userId).orElse(null);
            if (currentUser == null) {
                return ResponseEntity.status(404).body("User not found.");
            } else {
                if (!currentPlant.getUser().equals(currentUser)) {
                    return ResponseEntity.status(403).body("Not authorized!");
                } else {
                    plantRepository.deleteById(plantId);
                    return ResponseEntity.ok("Plant successfully deleted!");
                }
            }
        }
    }
}

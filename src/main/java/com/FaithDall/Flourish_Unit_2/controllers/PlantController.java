package com.FaithDall.Flourish_Unit_2.controllers;

import com.FaithDall.Flourish_Unit_2.models.Plant;
import com.FaithDall.Flourish_Unit_2.models.User;
import com.FaithDall.Flourish_Unit_2.repositories.PlantRepository;
import com.FaithDall.Flourish_Unit_2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/{userId}/plants")
public class PlantController {
    @Autowired
    private PlantRepository plantRepository;
    //had to inject another repository since I need to query the database for the user as well
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Plant> getUsersPlants(@PathVariable int userId) {
        return plantRepository.findByUserUserId(userId);
    }

    @PostMapping
    public Plant addPlant(@PathVariable int userId, @RequestBody Plant plant) {
        User plantOwner = userRepository.findById(userId).orElse(null);
        plant.setUser(plantOwner);
        return plantRepository.save(plant);
    }

    @PutMapping("{plantId}")
    public Plant updatePlant(@PathVariable int userId, @PathVariable int plantId, @RequestBody Plant plant) {
        Plant currentPlant = plantRepository.findById(plantId).orElse(null);
        User currentUser = userRepository.findById(userId).orElse(null);
        if (currentPlant.getUser().equals(currentUser)) {
            currentPlant.setNickname(plant.getNickname());
            return plantRepository.save(currentPlant);
        } else {
            return null;
        }
    }

    @DeleteMapping("{plantId}")
    public void deletePlant(@PathVariable int userId, @PathVariable int plantId) {
        Plant currentPlant = plantRepository.findById(plantId).orElse(null);
        User currentUser = userRepository.findById(userId).orElse(null);
        if (currentPlant.getUser().equals(currentUser)) {
            plantRepository.deleteById(plantId);
        }
    }
}

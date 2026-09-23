package com.FaithDall.Flourish_Unit_2.controllers;

import com.FaithDall.Flourish_Unit_2.models.Plant;
import com.FaithDall.Flourish_Unit_2.models.WateringLog;
import com.FaithDall.Flourish_Unit_2.repositories.PlantRepository;
import com.FaithDall.Flourish_Unit_2.repositories.WateringLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("users/{userId}/plants/{plantId}/logs")
public class WateringLogController {
    @Autowired
    private WateringLogRepository wateringLogRepository;
    //again injecting more than 1 repository for query purposes
    @Autowired
    private PlantRepository plantRepository;

    @GetMapping
    public List<WateringLog> getPlantsWateringLogs(@PathVariable int plantId) {
        return wateringLogRepository.findByPlantPlantId(plantId);
    }

    @PostMapping
    //doesn't need a RequestBody since the wateredAt field in my model is handled automatically
    public ResponseEntity<Object> addLog(@PathVariable int plantId){
        WateringLog log = new WateringLog();
        Plant currentPlant = plantRepository.findById(plantId).orElse(null);
        if (currentPlant == null) {
            return ResponseEntity.status(404).body("Plant not found.");
        } else {
            log.setPlant(currentPlant);
            return ResponseEntity.ok(wateringLogRepository.save(log));
        }
    }

}

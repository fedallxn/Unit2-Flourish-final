package com.FaithDall.Flourish_Unit_2.controllers;

import com.FaithDall.Flourish_Unit_2.models.Plant;
import com.FaithDall.Flourish_Unit_2.models.WateringLog;
import com.FaithDall.Flourish_Unit_2.repositories.PlantRepository;
import com.FaithDall.Flourish_Unit_2.repositories.WateringLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public WateringLog addLog(@PathVariable int plantId){
        WateringLog log = new WateringLog();
        Plant currentPlant = plantRepository.findById(plantId).orElse(null);
        log.setPlant(currentPlant);
        return wateringLogRepository.save(log);
    }

}

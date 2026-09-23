package com.FaithDall.Flourish_Unit_2.repositories;

import com.FaithDall.Flourish_Unit_2.models.WateringLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WateringLogRepository extends JpaRepository <WateringLog, Integer> {
    List<WateringLog> findByPlantPlantId(int plantId);
}

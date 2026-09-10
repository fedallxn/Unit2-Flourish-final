package com.FaithDall.Flourish_Unit_2.repositories;

import com.FaithDall.Flourish_Unit_2.models.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    List<Plant> findByUserUserId(int userId);
}

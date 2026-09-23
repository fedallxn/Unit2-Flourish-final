package com.FaithDall.Flourish_Unit_2.repositories;

import com.FaithDall.Flourish_Unit_2.models.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    //don't need a list because it's returning ONE species that matches the commonName
    Species findByCommonName(String commonName);
}

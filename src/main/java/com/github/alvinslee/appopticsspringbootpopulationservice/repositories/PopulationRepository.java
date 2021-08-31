package com.github.alvinslee.appopticsspringbootpopulationservice.repositories;

import com.github.alvinslee.appopticsspringbootpopulationservice.entities.Population;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PopulationRepository extends JpaRepository<Population, Integer> {
    List<Population> findAllByCityIdEquals(int cityId);
}

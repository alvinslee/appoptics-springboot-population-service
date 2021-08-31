package com.github.alvinslee.appopticsspringbootpopulationservice.repositories;

import com.github.alvinslee.appopticsspringbootpopulationservice.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findAllByStateIdEquals(int stateId);
}

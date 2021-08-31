package com.github.alvinslee.appopticsspringbootpopulationservice.repositories;

import com.github.alvinslee.appopticsspringbootpopulationservice.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> { }

package com.github.alvinslee.appopticsspringbootpopulationservice.controllers;

import com.github.alvinslee.appopticsspringbootpopulationservice.entities.City;
import com.github.alvinslee.appopticsspringbootpopulationservice.entities.Population;
import com.github.alvinslee.appopticsspringbootpopulationservice.entities.State;
import com.github.alvinslee.appopticsspringbootpopulationservice.repositories.CityRepository;
import com.github.alvinslee.appopticsspringbootpopulationservice.repositories.PopulationRepository;
import com.github.alvinslee.appopticsspringbootpopulationservice.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@Controller
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class SimpleController {
    private final CityRepository cityRepository;
    private final PopulationRepository populationRepository;
    private final StateRepository stateRepository;

    @GetMapping(value = "/states")
    public ResponseEntity<List<State>> getAllStates() {
        return new ResponseEntity<>(stateRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/states/{stateId}")
    public ResponseEntity<State> getStateById(@PathVariable int stateId) {
        try {
            return new ResponseEntity<>(stateRepository.findById(stateId).orElseThrow(() -> new Exception("Could not locate stateId=" + stateId)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/states/{stateId}/cities")
    public ResponseEntity<List<City>> getCitiesForStateId(@PathVariable int stateId) {
        return new ResponseEntity<>(cityRepository.findAllByStateIdEquals(stateId), HttpStatus.OK);
    }

    @GetMapping(value = "/states/{stateId}/cities/{cityId}")
    public ResponseEntity<City> getCityIdByCityIdAndStateId(@PathVariable int stateId, @PathVariable int cityId) {
        return getCityById(cityId);
    }

    @GetMapping(value = "/states/{stateId}/cities/{cityId}/population")
    public ResponseEntity<List<Population>> getPopulationForCityIdAndStateId(@PathVariable int stateId, @PathVariable int cityId) {
        return getPopulationForCityId(cityId);
    }

    @GetMapping(value = "/cities")
    public ResponseEntity<List<City>> getAllCities() {
        return new ResponseEntity<>(cityRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/cities/{cityId}")
    public ResponseEntity<City> getCityById(@PathVariable int cityId) {
        try {
            return new ResponseEntity<>(cityRepository.findById(cityId).orElseThrow(() -> new Exception("Could not locate cityId=" + cityId)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/cities/{cityId}/population")
    public ResponseEntity<List<Population>> getPopulationForCityId(@PathVariable int cityId) {
        return new ResponseEntity<>(populationRepository.findAllByCityIdEquals(cityId), HttpStatus.OK);
    }
}

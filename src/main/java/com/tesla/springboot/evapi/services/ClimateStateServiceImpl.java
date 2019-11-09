package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ClimateState;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.ClimateStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClimateStateServiceImpl implements ClimateStateService {

    private final ClimateStateRepository climateStateRepository;

    @Autowired
    public ClimateStateServiceImpl(ClimateStateRepository climateStateRepository) {
        this.climateStateRepository = climateStateRepository;
    }

    @Override
    public ClimateState findClimateStateById(Long id) {
        Optional<ClimateState> climateState = climateStateRepository.findById(id);
        if (climateState.isPresent()) {
            return climateState.get();
        } else {
            throw new ItemNotFoundException(id, "climate state");
        }
    }
}


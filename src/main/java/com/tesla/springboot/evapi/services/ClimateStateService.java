package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ClimateState;
import org.springframework.stereotype.Service;

@Service
public interface ClimateStateService {

    ClimateState findClimateStateById(Long id);

}

package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ClimateState;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;


@Service
public interface ClimateStateService {

    ClimateState findClimateStateById(Long id , Principal principal);
    void changeClimateState(Long id, Principal principal, Boolean on);
    void setTempById(Long id, Principal principal, Optional<Float> driverTemp, Optional<Float> passengerTemp);

}

package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ClimateState;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.ClimateStateRepository;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class ClimateStateServiceImpl implements ClimateStateService {

    private final VehicleRepository vehicleRepository;
    private final ClimateStateRepository climateStateRepository;

    @Autowired
    public ClimateStateServiceImpl(VehicleRepository vehicleRepository,
                                   ClimateStateRepository climateStateRepository) {
        this.vehicleRepository = vehicleRepository;
        this.climateStateRepository = climateStateRepository;
    }

    @Override
    public ClimateState findClimateStateById(Long id, Principal principal) {

        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        if(vehicle.isPresent()) {

            Optional<ClimateState> climateState = climateStateRepository.findById(id);
            if (climateState.isPresent()) {
                return climateState.get();
            } else {
                throw new ItemNotFoundException(id, "climate state");
            }
        }
        else{
            throw new ItemNotFoundException(id, "climate state");
        }
    }
}


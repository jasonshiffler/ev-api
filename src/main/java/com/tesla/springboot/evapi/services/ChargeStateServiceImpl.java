package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ChargeState;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.ChargeStateRepository;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class ChargeStateServiceImpl implements ChargeStateService {

    private final VehicleRepository vehicleRepository;
    private final ChargeStateRepository chargeStateRepository;

    @Autowired
    public ChargeStateServiceImpl(VehicleRepository vehicleRepository, ChargeStateRepository chargeStateRepository) {
        this.vehicleRepository = vehicleRepository;
        this.chargeStateRepository = chargeStateRepository;
    }

    @Override
    public ChargeState findChargeStateById(Long id, Principal principal) {

        /*Check to see if there is a matching vehicle with the same username as the id's of the corresponding tables
        are identical
        */

        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        //If so grab the charge state of the id
        if (vehicle.isPresent()) {

            Optional<ChargeState> chargeState = chargeStateRepository.findById(id);

            if (chargeState.isPresent()) {
                return chargeState.get();
            } else {
                throw new ItemNotFoundException(id, "charge state");
            }

        } else {
            throw new ItemNotFoundException(id, "charge state");
        }

    }
}


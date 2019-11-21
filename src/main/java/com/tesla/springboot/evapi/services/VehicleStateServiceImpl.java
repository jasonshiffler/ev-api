package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.entities.VehicleState;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import com.tesla.springboot.evapi.repositories.VehicleStateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@Slf4j
public class VehicleStateServiceImpl implements VehicleStateService  {

    private final VehicleRepository vehicleRepository;
    private final VehicleStateRepository vehicleStateRepository;

    /**
     * Constructor to setup our repository dependencies.
     * @param vehicleRepository
     * @param vehicleStateRepository
     */

    public VehicleStateServiceImpl(VehicleRepository vehicleRepository, VehicleStateRepository vehicleStateRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleStateRepository = vehicleStateRepository;
    }

    /**
     * Update the door lock status based on the fields passed in.
     * @param id - The id of the vehicle we want to lock/unlock
     * @param principal - The user making the request
     * @param locked - true for locked, false for unlocked
     */

    @Override
    public void lockUnlockDoors(Long id, Principal principal,Boolean locked) {

        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        if(vehicle.isPresent()) {
            //Grab VehicleState
            Optional<VehicleState> vehicleState = vehicleStateRepository.findById(id);

            if (vehicleState.isPresent()) {
                VehicleState vState = vehicleState.get();
                vState.setLocked(locked);                 //Set the door locked state based on the field passed in
                log.info("Saving door locked state");
                this.vehicleStateRepository.save(vState); //Update the record.

            } else {
                throw new ItemNotFoundException(id, "vehicle state"); // Throw an exception if we couldn't find the
            }                                                         // record
        }
        else {
            throw new ItemNotFoundException(id, "vehicle state");
        }
    }

}

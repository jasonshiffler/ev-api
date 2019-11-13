package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.DriveState;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.DriveStateRepository;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class DriveStateServiceImpl implements DriveStateService {

    private final DriveStateRepository driveStateRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public DriveStateServiceImpl(DriveStateRepository driveStateRepository, VehicleRepository vehicleRepository) {
        this.driveStateRepository = driveStateRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public DriveState findDriveStateById(Long id, Principal principal) {

        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        if (vehicle.isPresent()) {

            Optional<DriveState> driveState = driveStateRepository.findById(id);

            if (driveState.isPresent()) {
                return driveState.get();
            } else {
                throw new ItemNotFoundException(id, "drive state");
            }
        }
        else{
            throw new ItemNotFoundException(id, "drive state");
        }
    }
}

package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.DriveState;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.DriveStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriveStateImpl implements DriveStateService {

    private final DriveStateRepository driveStateRepository;

    @Autowired
    public DriveStateImpl(DriveStateRepository driveStateRepository) {
        this.driveStateRepository = driveStateRepository;
    }

    @Override
    public DriveState findDriveStateById(Long id) {
        Optional<DriveState> driveState = driveStateRepository.findById(id);

        if (driveState.isPresent()){
            return driveState.get();
        } else {
            throw new ItemNotFoundException(id,"drive state");
        }
    }
}

package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.DriveState;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DriveStateService {

    DriveState findDriveStateById(Long id);
}

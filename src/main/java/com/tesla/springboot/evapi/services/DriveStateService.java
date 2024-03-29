package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.DriveState;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public interface DriveStateService {

    DriveState findDriveStateById(Long id, Principal principal) throws ItemNotFoundException;
}

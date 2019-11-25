package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.exceptions.DataExpectedException;
import com.tesla.springboot.evapi.exceptions.DataOutOfBoundsException;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public interface VehicleStateService {
    void lockUnlockDoors(Long id, Principal principal,Boolean locked) throws ItemNotFoundException;
    void controlSunRoofById(Long id, Principal principal, String state, Optional<Integer> Percent) throws ItemNotFoundException, DataExpectedException, DataOutOfBoundsException;
}

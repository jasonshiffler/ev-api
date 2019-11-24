package com.tesla.springboot.evapi.services;

import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public interface VehicleStateService {
    void lockUnlockDoors(Long id, Principal principal,Boolean locked);
    void controlSunRoofById(Long id, Principal principal, String state, Optional<Integer> Percent);
}

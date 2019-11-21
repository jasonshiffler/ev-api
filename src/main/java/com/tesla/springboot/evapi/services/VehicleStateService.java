package com.tesla.springboot.evapi.services;

import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface VehicleStateService {
    void lockUnlockDoors(Long id, Principal principal,Boolean locked);

}

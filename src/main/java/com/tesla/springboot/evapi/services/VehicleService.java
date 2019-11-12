package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.Vehicle;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface VehicleService {

     Iterable<Vehicle> findAllVehicles(Integer size, Integer page, Principal principal);
     Vehicle findVehicleById(Long id,Principal principal);
     Iterable<Vehicle> findAllVehiclesByDisplayName(String displayName,
                                                    Integer size, Integer page, Principal principal);
}

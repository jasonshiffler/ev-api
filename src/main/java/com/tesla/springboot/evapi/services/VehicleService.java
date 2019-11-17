package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.controllers.CommandResponse;
import com.tesla.springboot.evapi.entities.Vehicle;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface VehicleService {

     Iterable<Vehicle> findAllVehicles(Integer size, Integer page, Principal principal);
     Vehicle findVehicleById(Long id,Principal principal);
     Iterable<Vehicle> findAllVehiclesByDisplayName(String displayName,
                                                    Integer size, Integer page, Principal principal);
     CommandResponse flashVehicleLightsById(Long id, Principal principal);
     CommandResponse honkVehicleHornById(Long id,Principal principal);
}

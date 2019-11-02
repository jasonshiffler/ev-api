package com.tesla.springboot.evapi.services;


import com.tesla.springboot.evapi.entities.DriveState;
import com.tesla.springboot.evapi.entities.Vehicle;
import org.springframework.stereotype.Service;

@Service
public interface VehicleService {

     Iterable<Vehicle> findAllVehicles(Integer size);
     Vehicle findVehicleById(Long id);
     Iterable<Vehicle> findAllVehiclesByDisplayName(String displayName, Integer size);
}

package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ChargeState;
import com.tesla.springboot.evapi.entities.Vehicle;
import org.springframework.stereotype.Service;

@Service
public interface VehicleService {

     Iterable<Vehicle> findAllVehicles();
     Vehicle findVehicleById(Long id);
     ChargeState findChargeStateById(Long id);

}

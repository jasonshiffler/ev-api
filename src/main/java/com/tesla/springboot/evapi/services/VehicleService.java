package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.controllers.CommandResponse;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Service
public interface VehicleService {

     Iterable<Vehicle> findAllVehicles(Integer size, Integer page, Principal principal) throws ItemNotFoundException;
     Vehicle findVehicleById(Long id, Principal principal, HttpServletRequest request) throws ItemNotFoundException;
     Iterable<Vehicle> findAllVehiclesByDisplayName(String displayName,
                                                    Integer size, Integer page, Principal principal) throws ItemNotFoundException;
     CommandResponse flashVehicleLightsById(Long id, Principal principal) throws ItemNotFoundException;
     CommandResponse honkVehicleHornById(Long id,Principal principal) throws ItemNotFoundException;
}

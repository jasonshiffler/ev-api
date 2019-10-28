package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public Iterable<Vehicle> findAllVehicles(){
      return vehicleService.findAllVehicles();
    }

}

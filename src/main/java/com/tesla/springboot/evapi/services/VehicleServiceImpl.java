package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ChargeState;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.ChargeStateRepository;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;


    @Autowired
    VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public Iterable<Vehicle> findAllVehicles(Integer size){

        return vehicleRepository.findAll();
    }

    public Vehicle findVehicleById(Long id) {

        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if (vehicle.isPresent()){
            return vehicle.get();
        } else {
            throw new ItemNotFoundException(id,"vehicle");
        }
    }

    @Override
    public Iterable<Vehicle> findAllVehiclesByDisplayName(String displayName, Integer size) {
        return vehicleRepository.findByDisplayNameContaining(displayName);
    }


}

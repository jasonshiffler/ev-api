package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ChargeState;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.ChargeStateRepository;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ChargeStateRepository chargeStateRepository;

    @Autowired
    VehicleServiceImpl(VehicleRepository vehicleRepository, ChargeStateRepository chargeStateRepository){
        this.vehicleRepository = vehicleRepository;
        this.chargeStateRepository = chargeStateRepository;
    }

    public Iterable<Vehicle> findAllVehicles(){
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
    public ChargeState findChargeStateById(Long id) {
        Optional<ChargeState> chargeState = chargeStateRepository.findById(id);

        if (chargeState.isPresent()){
            return chargeState.get();
        } else {
            throw new ItemNotFoundException(id,"charge state");
        }
    }

}

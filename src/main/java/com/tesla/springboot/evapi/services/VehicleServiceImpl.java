package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final AdjustQuerySizeService adjustQuerySizeService;


    @Autowired
    VehicleServiceImpl(VehicleRepository vehicleRepository, AdjustQuerySizeService adjustQuerySizeService){
        this.vehicleRepository = vehicleRepository;
        this.adjustQuerySizeService = adjustQuerySizeService;
    }

    public Iterable<Vehicle> findAllVehicles(Integer size){

        size = adjustQuerySizeService.AdjustQuerySize(size);
        Pageable request = PageRequest.of(0,size);
        Page<Vehicle> vehicles = vehicleRepository.findAll(request);
        return vehicles.getContent();
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

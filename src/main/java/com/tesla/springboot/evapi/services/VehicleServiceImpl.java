package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import com.tesla.springboot.evapi.utility.AdjustQuerySizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final AdjustQuerySizeService adjustQuerySizeService;

    /**
     *
     * @param vehicleRepository
     * @param adjustQuerySizeService
     */

    @Autowired
    VehicleServiceImpl(VehicleRepository vehicleRepository, AdjustQuerySizeService adjustQuerySizeService){
        this.vehicleRepository = vehicleRepository;
        this.adjustQuerySizeService = adjustQuerySizeService;
    }

    /**
     * Return all vehicles while allowing the search results to be paged and sized.
     *
     * @param size
     * @param page
     * @return
     */

    @Override
    public Iterable<Vehicle> findAllVehicles(Integer size, Integer page, Principal principal) {

        size = adjustQuerySizeService.AdjustQuerySize(size);
        Pageable request = PageRequest.of(page, size);
        Page<Vehicle> vehicles = vehicleRepository.findByUserId(principal.getName(),request);

        //Throw an exception if the page doesn't contain any results
        if (vehicles.hasContent() == false)
            throw new ItemNotFoundException("vehicle");

        //else return the content of the search
        return vehicles.getContent();
    }

    /**
     * Find the vehicle with the matching id
     *
     * @param id
     * @return - the V
     */

    @Override
    public Vehicle findVehicleById(Long id, Principal principal) {

        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id,principal.getName());

        if (vehicle.isPresent()){
            return vehicle.get();
        } else {
            throw new ItemNotFoundException(id,"vehicle");
        }
    }

    /**
     * Find vehicles that contain a matching term in the display name
     *
     * @param displayName - The display name of the vehicle we're searching on.
     * @param size - The number of results we want back
     * @param page - Which page of results we'd like
     * @return - The vehicles with a display name that contains the displayName field that was passed in.
     */

    @Override
    public Iterable<Vehicle> findAllVehiclesByDisplayName(String displayName, Integer size,
                                                          Integer page, Principal principal) {

        size = adjustQuerySizeService.AdjustQuerySize(size);
        Pageable request = PageRequest.of(page, size);
        Page<Vehicle> vehicles = vehicleRepository.findByDisplayNameContainingAndUserId(displayName,
                principal.getName(),request);

        //Throw an exception if the page doesn't contain any results
        if (vehicles.hasContent() == false)
            throw new ItemNotFoundException("vehicle");

        //else return the content of the search
        return vehicles.getContent();

    }
}

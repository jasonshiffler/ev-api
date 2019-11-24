/**
 * This service layer class handles anything to do with querying or updating vehicle data
 *
 */

package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.controllers.CommandResponse;
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
     * Constructor, used so we can inject our dependencies
     * @param vehicleRepository - The repository used to access our vehicle data
     * @param adjustQuerySizeService - A service that is used to adjust the query size based on configuration parameters
     */

    @Autowired
    VehicleServiceImpl(VehicleRepository vehicleRepository, AdjustQuerySizeService adjustQuerySizeService){
        this.vehicleRepository = vehicleRepository;
        this.adjustQuerySizeService = adjustQuerySizeService;
    }

    /**
     * Return all vehicles associated with a user while allowing the search results to be paged and sized.
     *
     * @param size - The number of records we want to get back
     * @param page - The page of the results we'd like to get back.
     * @param principal The user associated with the request
     * @return An Iterable of all the vehicles
     */

    @Override
    public Iterable<Vehicle> findAllVehicles(Integer size, Integer page, Principal principal) throws ItemNotFoundException {

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
     * @param id - The id of the record being requested
     * @param principal - The user associated with the request
     * @return - the Vehicle object
     */

    @Override
    public Vehicle findVehicleById(Long id, Principal principal) throws ItemNotFoundException {

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
                                                          Integer page, Principal principal) throws ItemNotFoundException {

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

    /**
     * Flash the lights on the car. There is no backend database record to update for this action.
     * @param id - The id of the vehicle we want to flash the lights of.
     * @param principal - The user associated with the request.
     * @return - Our standard command response object.
     */

    @Override
    public CommandResponse flashVehicleLightsById(Long id, Principal principal) throws ItemNotFoundException {

        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id,principal.getName());

        if (vehicle.isPresent()){
            return new CommandResponse();
        } else {
            throw new ItemNotFoundException(id,"vehicle");
        }
    }

    /**
     * Honk the horn of a particular vehicle. There is no backend database record to update for this action.
     * The method body is identical to the flashVehicleLightsById method. If this method actually honked the horn
     * of a real car it would make a different call so the methods have been split out.
     * @param id - The id of the vehicle we want to honk the horn of.
     * @param principal - The user associated with the request.
     * @return - Our standard command response object.
     */

    @Override
    public CommandResponse honkVehicleHornById(Long id, Principal principal) throws ItemNotFoundException {

        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id,principal.getName());

        if (vehicle.isPresent()){
            return new CommandResponse();
        } else {
            throw new ItemNotFoundException(id,"vehicle");
        }
    }




}

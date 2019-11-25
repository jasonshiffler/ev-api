package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.entities.VehicleState;
import com.tesla.springboot.evapi.exceptions.DataExpectedException;
import com.tesla.springboot.evapi.exceptions.DataOutOfBoundsException;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import com.tesla.springboot.evapi.repositories.VehicleStateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@Slf4j
public class VehicleStateServiceImpl implements VehicleStateService  {

    private final VehicleRepository vehicleRepository;
    private final VehicleStateRepository vehicleStateRepository;

    /**
     * Constructor to setup our repository dependencies.
     * @param vehicleRepository
     * @param vehicleStateRepository
     */

    public VehicleStateServiceImpl(VehicleRepository vehicleRepository, VehicleStateRepository vehicleStateRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleStateRepository = vehicleStateRepository;
    }

    /**
     * Update the door lock status based on the fields passed in.
     * @param id - The id of the vehicle we want to lock/unlock
     * @param principal - The user making the request
     * @param locked - true for locked, false for unlocked
     */

    @Override
    public void lockUnlockDoors(Long id, Principal principal,Boolean locked) throws ItemNotFoundException {

        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        if(vehicle.isPresent()) {
            //Grab VehicleState
            Optional<VehicleState> vehicleState = vehicleStateRepository.findById(id);

            if (vehicleState.isPresent()) {
                VehicleState vState = vehicleState.get();
                vState.setLocked(locked);                 //Set the door locked state based on the field passed in
                log.info("Saving door locked state");
                this.vehicleStateRepository.save(vState); //Update the record.

            } else {
                throw new ItemNotFoundException(id, "vehicle state"); // Throw an exception if we couldn't find the
            }                                                         // record
        }
        else {
            throw new ItemNotFoundException(id, "vehicle state");
        }
    }

    /**
     * Allows the caller to control the sunroof.
     * Can use predefined percentages or can be defined custom.
     *       open - 100%
     *       closed - 0%
     *       comfort - 80%
     *       vent - 15%
     *       move - specify {percent}
     * @param principal - The id of the vehicle we to control the sun roof of
     * @param state
     * @param percent - The percentage we want to open uup
     */
    @Override
    public void controlSunRoofById(Long id, Principal principal, String state, Optional<Integer> percent)
            throws ItemNotFoundException, DataExpectedException, DataOutOfBoundsException {

        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        if(vehicle.isPresent()) {
            //Grab VehicleState
            Optional<VehicleState> vehicleState = vehicleStateRepository.findById(id);

            if (vehicleState.isPresent()){
                VehicleState vState = vehicleState.get();

                if (state.equalsIgnoreCase("open")) {
                    vState.setSunRoofPercentOpen(100);
                    vState.setSunRoofState("open");
                    this.vehicleStateRepository.save(vState);
                }
                else if (state.equalsIgnoreCase("closed")) {
                    vState.setSunRoofPercentOpen(0);
                    vState.setSunRoofState("closed");
                    this.vehicleStateRepository.save(vState);
                }
                else if (state.equalsIgnoreCase("comfort")) {
                    vState.setSunRoofPercentOpen(80);
                    vState.setSunRoofState("comfort");
                    this.vehicleStateRepository.save(vState);
                }
                else if (state.equalsIgnoreCase("vent")) {
                    vState.setSunRoofPercentOpen(15);
                    vState.setSunRoofState("vent");
                    this.vehicleStateRepository.save(vState);
                }
                else if (state.equalsIgnoreCase("move")){
                    if (!percent.isPresent()) //if we get the custom keyword we're expecting a percentage
                        throw new DataExpectedException("Expected a percentage between 0 and 100 ");
                    if(percent.get()> 100 || percent.get() < 0)
                        throw new DataOutOfBoundsException("Expected a percentage between 0 and 100 ");
                    vState.setSunRoofPercentOpen(percent.get());
                    vState.setSunRoofState("move");
                    this.vehicleStateRepository.save(vState);
                }
                else {
                    throw new DataOutOfBoundsException("Expected a state of open, closed, comfort, vent, or move");
                }
            }
            else{ //we found the vehicle but it doesn't have a state record associated with it.
                throw new ItemNotFoundException(id, "vehicle state");
            }
        }
        else {
            throw new ItemNotFoundException(id, "vehicle state");
        }


    } //close method

} //close class

/**
 * This service layer class handles anything to do with querying or updating climate state data
 *
 */

package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ClimateState;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.DataExpectedException;
import com.tesla.springboot.evapi.exceptions.DataOutOfBoundsException;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.ClimateStateRepository;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@Slf4j
public class ClimateStateServiceImpl implements ClimateStateService {

    // These Spring Data JPA repositories allow us to query and update data from the Db

    private final VehicleRepository vehicleRepository;
    private final ClimateStateRepository climateStateRepository;

    /**
     * This is our constructor which is being used to inject our Repository dependencies.
     * @param vehicleRepository - Allows us to grab vehicle data from the database
     * @param climateStateRepository - Allows us to grab climate state data from the database
     */

    @Autowired
    public ClimateStateServiceImpl(VehicleRepository vehicleRepository,
                                   ClimateStateRepository climateStateRepository) {
        this.vehicleRepository = vehicleRepository;
        this.climateStateRepository = climateStateRepository;
    }

    /**
     * This method allows us to retrieve a climate state record associated with a particular id.
     * @param id - The primary key of the climate state record we want to view.
     * @param principal - The user making the information request
     * @return - The climate state object
     */
    @Override
    public ClimateState findClimateStateById(Long id, Principal principal) throws ItemNotFoundException {

        //Check to see if there is a vehicle that corresponds to the id and principal
        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        if(vehicle.isPresent()) {

            Optional<ClimateState> climateState = climateStateRepository.findById(id);
            if (climateState.isPresent()) {
                return climateState.get();
            } else {
                throw new ItemNotFoundException(id, "climate state");
            }
        }
        else{
            throw new ItemNotFoundException(id, "climate state");
        }
    }

    /**
     * This method allows us to turn the climate controls on or off.
     * @param id - The primary key of the climate state record we want to update
     * @param principal The user making the update request
     * @param on Set to true if we want to turn on the climate controls, false if we want to turn them off
     */

    @Override
    public void changeClimateState(Long id, Principal principal, Boolean on) throws ItemNotFoundException {

        // Check to see if there is a vehicle with the same id. Also verify the record requested is
        // associated with the same user.
        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        if(vehicle.isPresent()) {

            //Grab vehicle
            Optional<ClimateState> climateState = climateStateRepository.findById(id);

            if (climateState.isPresent()) {
               ClimateState climate = climateState.get();
               climate.setIsClimateOn(on);                 //Set the climate state based on the field passed in
               log.info("Saving Climate State");
               this.climateStateRepository.save(climate); //Update the record.

            } else {
                throw new ItemNotFoundException(id, "climate state"); // Throw an exception if we couldn't find the
            }                                                         // record
        }
        else{
            throw new ItemNotFoundException(id, "climate state");
        }
    }

    /**
     * Set's the driver's side and passenger side temperature.
     *
     * @param id - The primary key of the climate state record we want to change the temperature of
     * @param principal The user making the update request
     * @param driverTemp - The new temperature setting for the driver's side. Units are in Celsius.
     *                   If the value isn't present it will be ignored
     * @param passengerTemp - The new temperature setting for the driver's side. Units are in Celsius.
     *                      If the value isn't present it will be ignored
     */
    @Override
    public void setTempById(Long id, Principal principal, Optional<Float> driverTemp, Optional<Float> passengerTemp) throws ItemNotFoundException {

        //Need to have at least one of these values set
        if (!driverTemp.isPresent() && !passengerTemp.isPresent())
            throw new DataExpectedException();

        // Check to see if there is a vehicle with the same id. Also verify the record requested is
        // associated with the same user.
        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        if(vehicle.isPresent()) {
            Optional<ClimateState> climateState = climateStateRepository.findById(id); //Grab vehicle

            if (climateState.isPresent()) {
                ClimateState climate = climateState.get();
                 if (driverTemp.isPresent()) {                   //if the driver temp has been set
                   if (driverTemp.get() > climate.getMaxAvailTemp() ||
                           driverTemp.get() < climate.getMinAvailTemp()) // and isn't within an acceptable range
                     throw new DataOutOfBoundsException("Temperature must be between ",
                             climate.getMinAvailTemp(),
                             climate.getMaxAvailTemp(),
                             " degrees Celsius");
                   climate.setDriverTempSetting(driverTemp.get());  // if within a good range update the object
                                                               // with the new value
                 }
                if (passengerTemp.isPresent()) { // if the passenger temp has been set
                    if (passengerTemp.get() > climate.getMaxAvailTemp() ||
                            passengerTemp.get() < climate.getMinAvailTemp()) // and isn't within an acceptable range

                        throw new DataOutOfBoundsException("Temperature must be between ",
                                climate.getMinAvailTemp(),
                                climate.getMaxAvailTemp(),
                                " degrees Celsius");
                    climate.setPassengerTempSetting(passengerTemp.get()); //update the value if within a good range
                }
                this.climateStateRepository.save(climate); //Save the record in the database
            }
            else { // We found a vehicle but not a climate state for it.
                throw new ItemNotFoundException(id, "climate state");
            }
        }
        else { //If we didn't find a vehicle for this user with a matching id
            throw new ItemNotFoundException(id, "climate state"); //If no results came back from the vehicle repository
        }

    } // close method
}

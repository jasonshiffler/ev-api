/**
 * This controller handles any commands that have to do with vehicle state such as locking/unlocking
 * doors.
 */

package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.services.VehicleStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Secured("ROLE_USER") //We only want authenticated users to be able to access the controller
public class VehicleStateController {

    private final VehicleStateService vehicleStateService;

    @Autowired
    public VehicleStateController(VehicleStateService vehicleStateService) {
        this.vehicleStateService = vehicleStateService;
    }

    /**
     * Allows a user to unlock the doors of a vehicle with a particular id.
     * @param id - The id of the vehicle whose doors we are trying to unlock.
     * @param principal - The user who is making the request
     * @return - The standard command response
     */

    @GetMapping("/vehicles/{id}/command/door_unlock")
    public CommandResponse unlockDoorsById(@PathVariable Long id, Principal principal){
        try{
            vehicleStateService.lockUnlockDoors(id,principal,false);
        }
        catch (ItemNotFoundException e){
            throw new ItemNotFoundException(id,"Vehicle State");
        }
        return new CommandResponse();
    }

    /**
     * Allows a user to lock the doors of a vehicle with a particular id.
     * @param id - The id of the vehicle whose doors we are trying to lock.
     * @param principal - The user who is making the request
     * @return - The standard command response
     * */

    @GetMapping("/vehicles/{id}/command/door_lock")
    public CommandResponse lockDoorsById(@PathVariable Long id, Principal principal){
        try{
            vehicleStateService.lockUnlockDoors(id,principal,true);
        }
        catch (ItemNotFoundException e){
            throw new ItemNotFoundException(id,"Vehicle State");
        }
        return new CommandResponse();
    }
}
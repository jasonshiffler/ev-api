/**
 * This controller handles any commands that have to do with vehicle state such as locking/unlocking
 * doors.
 */

package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.exceptions.DataExpectedException;
import com.tesla.springboot.evapi.exceptions.DataOutOfBoundsException;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.services.VehicleStateService;
import com.tesla.springboot.evapi.utility.LogFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@RestController
@Secured("ROLE_USER") //We only want authenticated users to be able to access the controller
@Slf4j
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
    public CommandResponse unlockDoorsById(@PathVariable Long id, Principal principal, HttpServletRequest request)
            throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));

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
    public CommandResponse lockDoorsById(@PathVariable Long id, Principal principal,HttpServletRequest request)
            throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));
        try{
            vehicleStateService.lockUnlockDoors(id,principal,true);
        }
        catch (ItemNotFoundException e){
            throw new ItemNotFoundException(id,"Vehicle State");
        }
        return new CommandResponse();
    }

    /**
     * Allows the caller to control the roof.
     * Can use predefined percentages or can be defined custom.
     *
     * open - 100%
     * closed - 0%
     * comfort - 80%
     * vent - 15%
     * move - specify {percent}
     *
     * https://owner-api.teslamotors.com
     * /api/1/vehicles/:id/command/sun_roof_control?state=:state&percent=:percent
     *
     * @param id The id of the vehicle whose sun roof we want to control
     * @param principal- The user who is making the request
     * @return The standard command response
     */

    @GetMapping("/vehicles/{id}/command/sun_roof_control")
    public CommandResponse controlSunRoofById(@PathVariable Long id,
                                              @RequestParam(value = "state",required = true) String state,
                                              @RequestParam(value = "percent",required = false) Integer percent,
                                              HttpServletRequest request,
                                              Principal principal) throws ItemNotFoundException, DataExpectedException,
                                                                          DataOutOfBoundsException

    {
        //Log the request
        log.info(LogFormat.urlLogFormat(request,principal.getName()));

        Optional<Integer> optPercent = Optional.ofNullable(percent);

        try {
            vehicleStateService.controlSunRoofById(id,principal,state, optPercent);
            return new CommandResponse();
        }
        catch (ItemNotFoundException e){
            throw new ItemNotFoundException(id, "Vehicle State");
        }
        catch (DataExpectedException e){
            throw new DataExpectedException(e.getMessage());
        }
        catch( DataOutOfBoundsException e)
        {
            throw new DataOutOfBoundsException(e.getMessage());
        }

    } //close method

} //close class
/**
 * This controller handles any requests related to vehicle climate related requests
 *
 */

package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.entities.ClimateState;
import com.tesla.springboot.evapi.exceptions.DataExpectedException;
import com.tesla.springboot.evapi.exceptions.DataOutOfBoundsException;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.services.ClimateStateService;
import com.tesla.springboot.evapi.utility.LogFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@RestController
@Secured("ROLE_USER") //We only want authenticated users to be able to access the controller
@Slf4j
public class ClimateStateController {

    private final ClimateStateService climateStateService;

    @Autowired
    ClimateStateController(ClimateStateService climateStateService) {
        this.climateStateService = climateStateService;
    }

    /**
     *Allows us to grab the Climate state data of a particular vehicle associated to our account
     * @param id The id of the vehicle whose climate state we want
     * @param principal The currently logged in user
     * @return - The Climate State data in JSON format
     */
    @GetMapping("/vehicles/{id}/data_request/climate_state")
    public ClimateState findClimateStateById(@PathVariable Long id, Principal principal, HttpServletRequest request)
            throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));


        return climateStateService.findClimateStateById(id, principal);
    }

    /**
     * Turn on the HVAC system of a particular vehicle associated to our account
     * @param id The id of the vehicle whose HVAC system we want to start.
     * @param principal The currently logged in user
     * @return
     */
    @GetMapping("/vehicles/{id}/command/auto_conditioning_start")
    public CommandResponse startClimateHVACById(@PathVariable Long id, Principal principal,
                                                HttpServletRequest request) throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));

        try {
            climateStateService.changeClimateState(id, principal, true);
            return new CommandResponse();
        } catch (ItemNotFoundException e){
            throw new ItemNotFoundException(id, "climate state");
        }
    }

    /**
     * Turn off the HVAC system of a particular vehicle associated to our account
     * @param id The id of the vehicle whose HVAC system we want to start.
     * @param principal The currently logged in user
     * @return
     */
    @GetMapping("/vehicles/{id}/command/auto_conditioning_stop")
    public CommandResponse stopClimateHVACById(@PathVariable Long id, Principal principal,
                                               HttpServletRequest request) throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));

        try {
            climateStateService.changeClimateState(id, principal, false);
            return new CommandResponse();
        }
        catch (ItemNotFoundException e){
            throw new ItemNotFoundException(id, "climate state");
        }
    }

    /**
     * Adjust the driver and passenger side temperature.
     * API call should look like:
     *
     * /vehicles/:id/command/set_temps?driver_temp=:driver_temp&passenger_temp=:passenger_temp
     *
     * @param id - id of the vehicle/climate state to adjust
     * @param principal The currently logged in user
     * @param driverTemp - Temperature in celsius
     * @param passengerTemp Temperature in celsius
     * @return - returns the standard command response. we don't want to return that if there is an exception.
     */
    @GetMapping("/vehicles/{id}/command/set_temps")
    public CommandResponse setTempById(@PathVariable Long id, Principal principal,
                                       @RequestParam (value = "driver_temp", required = false) Float driverTemp,
                                       @RequestParam (value = "passenger_temp",required = false) Float passengerTemp,
                                       HttpServletRequest request) throws ItemNotFoundException,DataExpectedException,
                                                                          DataOutOfBoundsException

    {
        log.info(LogFormat.urlLogFormat(request,principal.getName()));

        Optional<Float> dTemp = Optional.ofNullable(driverTemp);
        Optional<Float> pTemp = Optional.ofNullable(passengerTemp);

        try {
            climateStateService.setTempById(id, principal, dTemp, pTemp);
            return new CommandResponse();
        }
        catch(DataExpectedException e){
            throw new DataExpectedException();
        }
        catch (DataOutOfBoundsException e){
            throw new DataOutOfBoundsException(e.getMessage());
        }
        catch (ItemNotFoundException e){
            throw new ItemNotFoundException(id, "climate state");
        }
    }
}

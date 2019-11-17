/**
 * This controller handles any requests related to vehicle climate related requests
 *
 */

package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.entities.ClimateState;
import com.tesla.springboot.evapi.exceptions.DataExpectedException;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.exceptions.TemperatureOutOfBoundsException;
import com.tesla.springboot.evapi.services.ClimateStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
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
    public ClimateState findClimateStateById(@PathVariable Long id, Principal principal) {
        return climateStateService.findClimateStateById(id, principal);
    }

    /**
     * Turn on the HVAC system of a particular vehicle associated to our account
     * @param id The id of the vehicle whose HVAC system we want to start.
     * @param principal The currently logged in user
     * @return
     */
    @GetMapping("/vehicles/{id}/command/auto_conditioning_start")
    public ControllerResponse startClimateHVACById(@PathVariable Long id, Principal principal) {

        try {
            climateStateService.changeClimateState(id, principal, true);
            return new ControllerResponse();
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
    public ControllerResponse stopClimateHVACById(@PathVariable Long id, Principal principal) {
        try {
            climateStateService.changeClimateState(id, principal, false);
            return new ControllerResponse();
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
     * @return
     */
    @GetMapping("/vehicles/{id}/command/set_temps")
    public ControllerResponse setTempById(@PathVariable Long id, Principal principal,
                                          @RequestParam (value = "driver_temp", required = false) Float driverTemp,
                                          @RequestParam (value = "passenger_temp",required = false) Float passengerTemp) {

        try {
            climateStateService.setTempById(id, principal, driverTemp, passengerTemp);
            return new ControllerResponse();
        }
        catch(DataExpectedException e){
            throw new DataExpectedException();
        }
        catch (TemperatureOutOfBoundsException e){
            throw new TemperatureOutOfBoundsException(e.getMessage());
        }
        catch (ItemNotFoundException e){
            throw new ItemNotFoundException(id, "climate state");
        }
    }



}

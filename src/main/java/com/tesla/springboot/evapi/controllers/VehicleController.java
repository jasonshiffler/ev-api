/**
 * This controller handles API requests at the vehicle level.
 *
 */

package com.tesla.springboot.evapi.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.tesla.springboot.evapi.entities.DriveState;
import com.tesla.springboot.evapi.entities.GuiSettings;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.services.DriveStateService;
import com.tesla.springboot.evapi.services.GuiSettingsService;
import com.tesla.springboot.evapi.services.VehicleService;
import com.tesla.springboot.evapi.utility.LogFormat;
import com.tesla.springboot.evapi.views.VehicleView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Slf4j
@Secured("ROLE_USER") //We only want authenticated users to be able to access the controller
public class VehicleController {

    private final VehicleService vehicleService;
    private final DriveStateService driveStateService;
    private final GuiSettingsService guiSettingsService;

    @Autowired
    VehicleController(VehicleService vehicleService,
                      DriveStateService driveStateService,
                      GuiSettingsService guiSettingsService) {

        this.vehicleService = vehicleService;
        this.driveStateService = driveStateService;
        this.guiSettingsService = guiSettingsService;
    }

    /**
     * Returns a list of all of the vehicles belonging to a particular principal in a summary format
     *
     * @param displayName - Allows us to search the vehicle list by display_name.
     * @param size - The number of records we want back.
     * @param page - The page of the request we want back.
     * @param request
     * @param principal - the user id associated with the request.
     * @return - An Iterable of all vehicles associated with the user the @JsonView annotation will make sure only
     *           a summary view is displayed.
     */
    @JsonView(VehicleView.summary.class)
    @GetMapping("/vehicles")
    public Iterable<Vehicle> findAllVehicles(@RequestParam(value = "display_name",required = false) String displayName,
                                             @RequestParam(value = "size",required = false) Integer size,
                                             @RequestParam(value = "page",required = false) Integer page,
                                             HttpServletRequest request, Principal principal) throws ItemNotFoundException {

        //Log the request
        log.info(LogFormat.urlLogFormat(request,principal.getName()));

        // Set a default value for the page if none was passed in.
        if (page == null)
            page = Integer.valueOf(0);

        //Adjust the search based on if the display name was set or not

        if (displayName == null) {
            return vehicleService.findAllVehicles(size, page,principal);
        } else
            return vehicleService.findAllVehiclesByDisplayName(displayName,size,page,principal);
    }

    /**
     * Returns the summary of a vehicle with a particular id
     * @param id - The id of the vehicle we want the data for.
     * @param principal the user id associated with the request.
     * @return A Vehicle object, the JsonView annotation will make sure that only a summary is displayed
     */
    @JsonView(VehicleView.summary.class)
    @GetMapping("/vehicles/{id}")
    public Vehicle findVehicleById(@PathVariable Long id, Principal principal,
                                   HttpServletRequest request) throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));
        return vehicleService.findVehicleById(id,principal, request);
     }

    /**
     * Returns a detailed view of the information associated with a particular vehicle
     * @param id - The id of the vehicle we want the data for.
     * @param principal - the user id associated with the request.
     * @return A Vehicle object, the JsonView annotation will make sure that all detail is displayed
     */

    @JsonView(VehicleView.detail.class)
    @GetMapping("/vehicles/{id}/vehicle_data")
    public Vehicle findVehicleDataById(@PathVariable Long id, Principal principal,
                                       HttpServletRequest request)throws ItemNotFoundException {
        log.info(LogFormat.urlLogFormat(request,principal.getName()));
        return vehicleService.findVehicleById(id,principal, request);
    }

    /**
     * Allows the user to flash the lights on a particular vehicle.
     * @param id - The id of the vehicle we wish to flash the lights.
     * @param principal - The user making the request.
     * @return Returns a command response object.
     */

    @GetMapping("/vehicles/{id}/command/flash_lights")
    public CommandResponse flashVehicleLightsById(@PathVariable Long id, Principal principal,
                                                  HttpServletRequest request) throws ItemNotFoundException {
        log.info(LogFormat.urlLogFormat(request,principal.getName()));
        return vehicleService.flashVehicleLightsById(id,principal);
    }

    /**
     * Allows the user to honk the horn on a particular vehicle.
     * @param id - The id of the vehicle we wish to honk the horn of.
     * @param principal - The user making the request.
     * @return Returns a command response object.
     */

    @GetMapping("/vehicles/{id}/command/honk_horn")
    public CommandResponse honkVehicleHornById(@PathVariable Long id, Principal principal,
                                               HttpServletRequest request) throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));
        return vehicleService.honkVehicleHornById(id,principal);
    }

    @GetMapping("/vehicles/{id}/data_request/drive_state")
    public DriveState findDriveStateById(@PathVariable Long id, Principal principal,
                                         HttpServletRequest request) throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));
        return driveStateService.findDriveStateById(id, principal);
    }

    @GetMapping("/vehicles/{id}/data_request/gui_settings")
    public GuiSettings findGUISettingsById(@PathVariable Long id, Principal principal,
                                           HttpServletRequest request) throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));
        return guiSettingsService.findGUISettingsById(id, principal);
    }


}

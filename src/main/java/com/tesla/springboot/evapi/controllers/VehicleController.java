package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.entities.ChargeState;
import com.tesla.springboot.evapi.entities.DriveState;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.services.ChargeStateService;
import com.tesla.springboot.evapi.services.DriveStateService;
import com.tesla.springboot.evapi.services.VehicleService;
import com.tesla.springboot.evapi.utility.LogFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class VehicleController {

    private final VehicleService vehicleService;
    private final DriveStateService driveStateService;
    private final ChargeStateService chargeStateService;

    @Autowired
    VehicleController(VehicleService vehicleService, DriveStateService driveStateService,
                      ChargeStateService chargeStateService){
        this.vehicleService = vehicleService;
        this.driveStateService = driveStateService;
        this.chargeStateService = chargeStateService;
    }

    @GetMapping("/vehicles")
    public Iterable<Vehicle> findAllVehicles(@RequestParam(value = "display_name",required = false) String displayName,
                                             @RequestParam(value = "size",required = false) Integer size,
                                             @RequestParam(value = "page",required = false) Integer page,
                                             HttpServletRequest request){

        log.info(LogFormat.urlLogFormat(request));

        // Set a default value for the page if none was passed in.
        if (page == null)
            page = Integer.valueOf(0);

        //Adjust the search based on if the display name was set or not

        if (displayName == null) {
            return vehicleService.findAllVehicles(size, page);
        } else
            return vehicleService.findAllVehiclesByDisplayName(displayName,size,page);
    }


    @GetMapping("/vehicles/{id}")
    public Vehicle findVehicleById(@PathVariable Long id) {
       return vehicleService.findVehicleById(id);
     }


    @GetMapping("/vehicles/{id}/data_request/charge_state")
    public ChargeState findChargeStateById(@PathVariable Long id) {
        return chargeStateService.findChargeStateById(id);
    }

    @GetMapping("/vehicles/{id}/data_request/drive_state")
    public DriveState findDriveStateById(@PathVariable Long id) {
        return driveStateService.findDriveStateById(id);
    }
}

package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.GuiSettings;
import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.GuiSettingsRepository;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Optional;

public class GuiSettingsServiceImpl implements GuiSettingsService {

    private final GuiSettingsRepository guiSettingsRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public GuiSettingsServiceImpl(GuiSettingsRepository guiSettingsRepository, VehicleRepository vehicleRepository) {
        this.guiSettingsRepository = guiSettingsRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public GuiSettings findGUISettingsById(Long id, Principal principal) {
        Optional<Vehicle> vehicle = vehicleRepository.findByIdAndUserId(id, principal.getName());

        if (vehicle.isPresent()) {

            Optional<GuiSettings> guiSettings = guiSettingsRepository.findById(id);

            if (guiSettings.isPresent()) {
                return guiSettings.get();
            } else {
                throw new ItemNotFoundException(id, "Gui Settings");
            }
        }
        else{
            throw new ItemNotFoundException(id, "Gui Settings");
        }
    } //close method
 }

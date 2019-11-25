package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.services.DriveStateService;
import com.tesla.springboot.evapi.services.GuiSettingsService;
import com.tesla.springboot.evapi.services.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import java.security.Principal;

import static org.mockito.Mockito.verify;

@DisplayName("Vehicle Controller Tests")
@ExtendWith(MockitoExtension.class)
class VehicleControllerTest {

    @Mock
    VehicleService vService;
    @Mock
    GuiSettingsService gService;
    @Mock
    DriveStateService dService;
    @Mock
    HttpServletRequest request;
    @Mock
    Principal principal;

    @InjectMocks
    VehicleController controller;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findVehicleById() throws ItemNotFoundException {
        controller.findVehicleById(5L,principal,request);
        verify(vService).findVehicleById(5L,principal,request);
    }

    @Test
    void findAllVehicles() {
    }


    @Test
    void findVehicleDataById() throws ItemNotFoundException {
        controller.findVehicleDataById(5L,principal,request);
        verify(vService).findVehicleById(5L,principal,request);
    }

    @Test
    void flashVehicleLightsById() throws ItemNotFoundException {
        controller.flashVehicleLightsById(5L,principal,request);
        verify(vService).flashVehicleLightsById(5L,principal);
    }

    @Test
    void honkVehicleHornById()throws ItemNotFoundException {
        controller.honkVehicleHornById(5L,principal,request);
        verify(vService).honkVehicleHornById(5L,principal);
    }

    @Test
    void findDriveStateById() throws ItemNotFoundException {
        controller.findDriveStateById(5L,principal,request);
        verify(dService).findDriveStateById(5L,principal);
    }

    @Test
    void findGUISettingsById() throws ItemNotFoundException {
        controller.findGUISettingsById(5L,principal,request);
        verify(gService).findGUISettingsById(5L,principal);
    }
}
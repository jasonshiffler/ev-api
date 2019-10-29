package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.entities.Vehicle;
import com.tesla.springboot.evapi.repositories.VehicleRepository;
import com.tesla.springboot.evapi.services.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@DisplayName("Vehicle Controller Tests")
@ExtendWith(MockitoExtension.class)
class VehicleControllerTest {

    @Mock
    VehicleService service;

    @Mock
    VehicleRepository repository;

    @InjectMocks
    VehicleController controller;

    Vehicle vehicle;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findAllVehiclesTest() {
        controller.findAllVehicles();
        verify(service).findAllVehicles();
    }

    @Test
    void findVehicleByIdTest() {
        controller.findVehicleById(5L);
        verify(service).findVehicleById(5L);
    }
}
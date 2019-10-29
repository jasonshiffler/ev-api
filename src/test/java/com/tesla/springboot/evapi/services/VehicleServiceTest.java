package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.repositories.VehicleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@DisplayName("Vehicle Service Tests")
@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    VehicleRepository repository;

    @InjectMocks
    VehicleService service;

    @Test
    void findAllVehiclesTest() {
        service.findAllVehicles();
        verify(repository).findAll();
    }

    @Test
    void findVehicleByIdTest() {
        service.findVehicleById(5L);
        verify(repository).findById(5L);
    }
}
package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.services.ChargeStateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

import static org.mockito.Mockito.verify;

@DisplayName("Charge State Controller Tests")
@ExtendWith(MockitoExtension.class)
public class ChargeStateControllerTest {

    @Mock
    ChargeStateService cService;

    @Mock
    Principal principal;

    @Mock
    HttpServletRequest request;

    @InjectMocks
    ChargeStateController controller;


    @Test
    public void findChargeStateByIdTest() throws ItemNotFoundException {
        controller.findChargeStateById(5L,principal,request);
        verify(cService).findChargeStateById(5L,principal);
    }

    @Test
    public void openChargePortByIdTest() throws ItemNotFoundException {
        controller.openChargePortById(5L,principal,request);
        verify(cService).openCloseChargePortById(5L,principal,true);
    }

    @Test
    public void closeChargePortByIdTest() throws ItemNotFoundException {
        controller.closeChargePortById(5L,principal,request);
        verify(cService).openCloseChargePortById(5L,principal,false);
    }
}
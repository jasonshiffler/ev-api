package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ChargeState;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface ChargeStateService {

    ChargeState findChargeStateById(Long id, Principal principal) throws ItemNotFoundException;
}

package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ChargeState;
import org.springframework.stereotype.Service;

@Service
public interface ChargeStateService {

    ChargeState findChargeStateById(Long id);
}

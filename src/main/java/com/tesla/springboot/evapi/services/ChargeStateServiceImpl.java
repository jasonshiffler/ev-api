package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.ChargeState;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.repositories.ChargeStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChargeStateServiceImpl implements ChargeStateService {

    private final ChargeStateRepository chargeStateRepository;

    @Autowired
    public ChargeStateServiceImpl(ChargeStateRepository chargeStateRepository) {
        this.chargeStateRepository = chargeStateRepository;
    }

    @Override
    public ChargeState findChargeStateById(Long id) {
        Optional<ChargeState> chargeState = chargeStateRepository.findById(id);

        if (chargeState.isPresent()){
            return chargeState.get();
        } else {
            throw new ItemNotFoundException(id,"charge state");
        }
    }

}

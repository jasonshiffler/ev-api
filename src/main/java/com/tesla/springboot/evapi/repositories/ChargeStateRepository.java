package com.tesla.springboot.evapi.repositories;

import com.tesla.springboot.evapi.entities.ChargeState;
import org.springframework.data.repository.CrudRepository;

public interface ChargeStateRepository extends CrudRepository<ChargeState, Long> {
}

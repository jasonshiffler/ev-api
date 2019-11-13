package com.tesla.springboot.evapi.repositories;

import com.tesla.springboot.evapi.entities.ClimateState;
import org.springframework.data.repository.CrudRepository;


public interface ClimateStateRepository extends CrudRepository<ClimateState,Long> {


}

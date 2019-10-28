package com.tesla.springboot.evapi.repositories;

import com.tesla.springboot.evapi.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}

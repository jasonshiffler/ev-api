package com.tesla.springboot.evapi.repositories;

import com.tesla.springboot.evapi.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {


    Iterable<Vehicle> findByDisplayNameContaining(String displayName);
}

package com.tesla.springboot.evapi.repositories;

import com.tesla.springboot.evapi.entities.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {

    Page<Vehicle> findByDisplayNameContainingAndUserId(String displayName, String userId, Pageable pageable);
    Page<Vehicle> findByUserId(String userId, Pageable pageable);
}

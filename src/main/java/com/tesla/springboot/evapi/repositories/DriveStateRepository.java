package com.tesla.springboot.evapi.repositories;

import com.tesla.springboot.evapi.entities.DriveState;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DriveStateRepository extends CrudRepository<DriveState, Long> {

}

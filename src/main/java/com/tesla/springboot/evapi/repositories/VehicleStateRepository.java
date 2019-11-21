/**
 * Handles an database requests for VehicleState information
 *
 */

package com.tesla.springboot.evapi.repositories;

import com.tesla.springboot.evapi.entities.VehicleState;
import org.springframework.data.repository.CrudRepository;

public interface VehicleStateRepository extends CrudRepository<VehicleState, Long> {
}

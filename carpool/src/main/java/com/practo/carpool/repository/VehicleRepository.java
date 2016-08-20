/**
 * 
 */
package com.practo.carpool.repository;

import org.springframework.data.repository.CrudRepository;

import com.practo.carpool.data.entity.Vehicle;

/**
 * @author aditya
 *
 */
public interface VehicleRepository extends CrudRepository<Vehicle,Integer> {

}

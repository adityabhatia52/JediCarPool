/**
 * 
 */
package com.practo.carpool.repository;

import org.springframework.data.repository.CrudRepository;

import com.practo.carpool.data.entity.Address;

/**
 * @author aditya
 *
 */
public interface AddressRepository extends CrudRepository<Address,Integer> {

}

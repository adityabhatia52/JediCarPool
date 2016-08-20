/**
 * 
 */
package com.practo.carpool.repository;

import org.springframework.data.repository.CrudRepository;

import com.practo.carpool.data.entity.Booking;

/**
 * @author aditya
 *
 */
public interface BookingRepository extends CrudRepository<Booking,Integer>  {

}

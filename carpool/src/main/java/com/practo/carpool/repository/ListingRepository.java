package com.practo.carpool.repository;

import org.springframework.data.repository.CrudRepository;

import com.practo.carpool.data.entity.Listing;

public interface ListingRepository extends CrudRepository<Listing,Integer>  {

}

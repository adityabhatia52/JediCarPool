/**
 * 
 */
package com.practo.carpool.service;

import org.springframework.data.domain.Pageable;

import com.practo.carpool.data.model.ListingModel;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
public interface ListingService {

  public Iterable<ListingModel> get(Pageable pageable);

  public ListingModel get(int id) throws NotFoundException;

  public ListingModel create(ListingModel addModel);

  public ListingModel update(ListingModel addModel, int id) throws NotFoundException;

  public void delete(int id) throws NotFoundException;

}

/**
 * 
 */
package com.practo.carpool.service;

import com.practo.carpool.data.model.ListingModel;

/**
 * @author aditya
 *
 */
public interface ListingService {
  
  public Iterable<ListingModel> get();

  public ListingModel get(int id);

  public ListingModel create(ListingModel addModel);

  public ListingModel update(ListingModel addModel, int id);

  public void delete(int id);

}

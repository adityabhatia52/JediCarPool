/**
 * 
 */
package com.practo.carpool.service;

import com.practo.carpool.data.model.AddressModel;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */

public interface AddressService {

  public Iterable<AddressModel> get();

  public AddressModel get(int id) throws NotFoundException;

  public AddressModel create(AddressModel addModel);

  public AddressModel update(AddressModel addModel, int id) throws NotFoundException;

  public void delete(int id) throws NotFoundException;

}

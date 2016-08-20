/**
 * 
 */
package com.practo.carpool.service;

import com.practo.carpool.data.model.AddressModel;

/**
 * @author aditya
 *
 */

public interface AddressService {

  public Iterable<AddressModel> get();

  public AddressModel get(int id);

  public AddressModel create(AddressModel addModel);

  public AddressModel update(AddressModel addModel, int id);

  public void delete(int id);

}

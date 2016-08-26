/**
 * 
 */
package com.practo.carpool.service;

import com.practo.carpool.data.model.UserModel;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
public interface UserService {

  public Iterable<UserModel> get();

  public UserModel get(int id) throws NotFoundException;

  public UserModel create(UserModel userModel);

  public UserModel update(UserModel userModel, int id) throws NotFoundException;

  public void delete(int id) throws NotFoundException;

}

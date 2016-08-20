/**
 * 
 */
package com.practo.carpool.service;

import com.practo.carpool.data.model.UserModel;

/**
 * @author aditya
 *
 */
public interface UserService {
  
  public Iterable<UserModel> get();
  
  public UserModel get(int id);

  public UserModel create(UserModel userModel);

  public UserModel update(UserModel userModel,int id);
  
  public void delete(int id);

}

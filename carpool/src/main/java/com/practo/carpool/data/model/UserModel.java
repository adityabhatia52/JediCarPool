package com.practo.carpool.data.model;

import java.io.Serializable;

import com.practo.carpool.data.entity.User;
import com.practo.carpool.exceptions.NotFoundException;

public class UserModel implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private int id;

  private String email;

  private String mobile;

  private String name;

  public UserModel() {}

  public UserModel(String email, String mobile, String name) {
    this.name = name;
    this.mobile = mobile;
    this.email = email;
  }

  public UserModel(int id, String email, String mobile, String name) {
    this.id = id;
    this.email = email;
    this.mobile = mobile;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return this.mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // model to entity
  public User entityGet() {
    User userEntity = new User();
    userEntity.setEmail(getEmail());
    userEntity.setName(getName());
    userEntity.setMobile(getMobile());
    if (new Integer(getId()) != null)
      userEntity.setId(getId());
    return userEntity;
  }

  // entity to model
  public void entityPost(User e) throws NotFoundException {
    if (e != null && e.getDeletedAt() == null) {
      setName(e.getName());
      setEmail(e.getEmail());
      setMobile(e.getMobile());
      setId(e.getId());
    } else {
      throw new NotFoundException("User with given id doesn't exist");
    }
  }
}



package com.practo.carpool.data.model;

import java.io.Serializable;
import java.util.Date;

import com.practo.carpool.data.entity.Vehicle;

public class VehicleModel implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;

  private byte active;

  private int capacity;

  private Date createdAt;

  private Date deletedAt;

  private String model;

  private Date modifiedAt;

  private String numberPlate;

  private UserModel userModel;

  public VehicleModel() {}

  public VehicleModel(int id, int capacity, String model, String numberPlate, UserModel userModel) {
    this.id = id;
    this.capacity = capacity;
    this.model = model;
    this.numberPlate = numberPlate;
    this.userModel = userModel;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public byte getActive() {
    return this.active;
  }

  public void setActive(byte active) {
    this.active = active;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getDeletedAt() {
    return this.deletedAt;
  }

  public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Date getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public String getNumberPlate() {
    return this.numberPlate;
  }

  public void setNumberPlate(String numberPlate) {
    this.numberPlate = numberPlate;
  }

  public UserModel getUserModel() {
    return this.userModel;
  }

  public void setUserModel(UserModel userModel) {
    this.userModel = userModel;
  }


  // model to entity
  public Vehicle entityGet() {
    Vehicle vehicleEntity = new Vehicle();
    vehicleEntity.setModel(getModel());
    vehicleEntity.setNumberPlate(getNumberPlate());
    vehicleEntity.setCapacity(getCapacity());
    if (new Integer(getId()) != null)
      vehicleEntity.setId(getId());
    vehicleEntity.setUser(this.getUserModel().entityGet());
    return vehicleEntity;
  }

  // entity to model
  public void entityPost(Vehicle vehicleEntity) {
    if (vehicleEntity != null) {
      setModel(vehicleEntity.getModel());
      setNumberPlate(vehicleEntity.getNumberPlate());
      setCapacity(vehicleEntity.getCapacity());
      UserModel userModel = new UserModel();
      userModel.entityPost(vehicleEntity.getUser());
      setUserModel(userModel);
    }
  }
}

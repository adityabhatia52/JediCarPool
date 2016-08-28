package com.practo.carpool.data.model;

import java.io.Serializable;

import com.practo.carpool.data.entity.Vehicle;
import com.practo.carpool.exceptions.NotFoundException;

public class VehicleModel implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;

  private int capacity;

  private String model;

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

  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }


  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
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
    if (this.getUserModel() != null) {
      vehicleEntity.setUser(this.getUserModel().entityGet());
    }
    return vehicleEntity;
  }

  // entity to model
  public void entityPost(Vehicle vehicleEntity) throws NotFoundException {
    if (vehicleEntity != null && vehicleEntity.getDeletedAt()==null) {
      setId(vehicleEntity.getId());
      setModel(vehicleEntity.getModel());
      setNumberPlate(vehicleEntity.getNumberPlate());
      setCapacity(vehicleEntity.getCapacity());
      UserModel userModel = new UserModel();
      try {
        userModel.entityPost(vehicleEntity.getUser());
        setUserModel(userModel);
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }
    } else {
      throw new NotFoundException("Vehicle with given id doesn't exist");
    }
  }
}

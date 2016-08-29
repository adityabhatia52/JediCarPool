/**
 * 
 */
package com.practo.carpool.data.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.practo.carpool.data.entity.Listing;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
public class ListingModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private byte availability;

  private Timestamp departTime;

  private int seatAvailable;

  private AddressModel addressModel;

  private SourceModel sourceModel;

  private UserModel userModel;

  private VehicleModel vehicleModel;

  public ListingModel() {};

  public ListingModel(Timestamp departTime, int seatAvailable, SourceModel sourceModel,
      UserModel userModel, VehicleModel vehicleModel, AddressModel addressModel) {
    this.userModel = userModel;
    this.vehicleModel = vehicleModel;
    this.addressModel = addressModel;
    this.seatAvailable = seatAvailable;
    this.sourceModel = sourceModel;
    this.departTime = departTime;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public byte getAvailability() {
    return this.availability;
  }

  public void setAvailability(byte availability) {
    this.availability = availability;
  }

  public Timestamp getDepartTime() {
    return this.departTime;
  }

  public void setDepartTime(Timestamp departTime) {
    this.departTime = departTime;
  }

  public int getSeatAvailable() {
    return this.seatAvailable;
  }

  public void setSeatAvailable(int seatAvailable) {
    this.seatAvailable = seatAvailable;
  }

  public AddressModel getAddressModel() {
    return this.addressModel;
  }

  public void setAddressModel(AddressModel addressModel) {
    this.addressModel = addressModel;
  }

  public SourceModel getSourceModel() {
    return this.sourceModel;
  }

  public void setSourceModel(SourceModel sourceModel) {
    this.sourceModel = sourceModel;
  }

  public UserModel getUserModel() {
    return this.userModel;
  }

  public void setUserModel(UserModel userModel) {
    this.userModel = userModel;
  }

  public VehicleModel getVehicleModel() {
    return this.vehicleModel;
  }

  public void setVehicleModel(VehicleModel vehicleModel) {
    this.vehicleModel = vehicleModel;
  }

  // model to entity
  public Listing entityGet() {
    Listing ListingEntity = new Listing();
    if (this.getUserModel() != null) {
      ListingEntity.setUser(this.getUserModel().entityGet());
    }
    if (this.getVehicleModel() != null) {
      ListingEntity.setVehicle(this.getVehicleModel().entityGet());
    }
    if (this.getAddressModel() != null) {
      ListingEntity.setAddress(this.getAddressModel().entityGet());
    }
    if (this.getSourceModel() != null) {
      ListingEntity.setSource(this.getSourceModel().entityGet());
    }
    ListingEntity.setSeatAvailable(getSeatAvailable());
    ListingEntity.setDepartTime(getDepartTime());
    ListingEntity.setAvailability(getAvailability());
    if (new Integer(getId()) != null) {
      ListingEntity.setId(getId());
    }
    return ListingEntity;
  }

  // entity to model
  public void entityPost(Listing listingEntity) throws NotFoundException {
    if (listingEntity != null && listingEntity.getDeletedAt() == null
        && listingEntity.getSeatAvailable() > 0) {

      UserModel uModel = new UserModel();
      try {
        uModel.entityPost(listingEntity.getUser());
        setUserModel(uModel);
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }

      VehicleModel vModel = new VehicleModel();
      try {
        vModel.entityPost(listingEntity.getVehicle());
        setVehicleModel(vModel);
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }

      AddressModel aModel = new AddressModel();
      try {
        aModel.entityPost(listingEntity.getAddress());
        setAddressModel(aModel);
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }
      SourceModel sModel = new SourceModel();
      try {
        sModel.entityPost(listingEntity.getSource());
        setSourceModel(sModel);
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }
      setAvailability(listingEntity.getAvailability());
      setSeatAvailable(listingEntity.getSeatAvailable());
      setDepartTime(listingEntity.getDepartTime());
      setId(listingEntity.getId());
    } else {
      throw new NotFoundException("Listing with given id doesn't exist");
    }
  }

}

/**
 * 
 */
package com.practo.carpool.data.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author aditya
 *
 */
public class ListingModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private byte availability;

  private Date createdAt;

  private Date deletedAt;

  private Timestamp departTime;

  private Date modifiedAt;

  private int seatAvailable;

  private List<BookingModel> bookingsModel;

  private AddressModel addressModel;

  private SourceModel sourceModel;

  private UserModel userModel;

  private VehicleModel vehicleModel;

  public ListingModel(){};
  
  public ListingModel(Timestamp departTime, int seatAvailable, SourceModel sourceModel,
      UserModel userModel, VehicleModel vehicleModel,AddressModel addressModel) {
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

  public Timestamp getDepartTime() {
    return this.departTime;
  }

  public void setDepartTime(Timestamp departTime) {
    this.departTime = departTime;
  }

  public Date getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public int getSeatAvailable() {
    return this.seatAvailable;
  }

  public void setSeatAvailable(int seatAvailable) {
    this.seatAvailable = seatAvailable;
  }

  public List<BookingModel> getBookings() {
    return this.bookingsModel;
  }

  public void setBookings(List<BookingModel> bookings) {
    this.bookingsModel = bookings;
  }

  public AddressModel getAddressModel() {
    return this.addressModel;
  }

  public void setAddress(AddressModel addressModel) {
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

}

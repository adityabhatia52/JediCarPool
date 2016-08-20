/**
 * 
 */
package com.practo.carpool.data.model;

import java.io.Serializable;
import java.util.Date;

import com.practo.carpool.data.entity.Booking;

/**
 * @author aditya
 *
 */
public class BookingModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private int idBooking;

  private byte active;

  private Date createdAt;

  private Date deletedAt;

  private Date modifiedAt;

  private ListingModel listingModel;

  private UserModel userModel;

  public BookingModel() {}

  public BookingModel(ListingModel listingModel, UserModel userModel) {
    this.listingModel = listingModel;
    this.userModel = userModel;

  }

  public int getIdBooking() {
    return this.idBooking;
  }

  public void setIdBooking(int idBooking) {
    this.idBooking = idBooking;
  }

  public byte getActive() {
    return this.active;
  }

  public void setActive(byte active) {
    this.active = active;
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

  public Date getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public ListingModel getListingModel() {
    return this.listingModel;
  }

  public void setListingModel(ListingModel listingModel) {
    this.listingModel = listingModel;
  }

  public UserModel getUserModel() {
    return this.userModel;
  }

  public void setUserModel(UserModel userModel) {
    this.userModel = userModel;
  }

  // model to entity
  public Booking entityGet() {
    Booking BookingEntity = new Booking();
    BookingEntity.setUser(this.getUserModel().entityGet());
    BookingEntity.setListing(this.getListingModel().entityGet());
    if (new Integer(getIdBooking()) != null)
      BookingEntity.setIdBooking(getIdBooking());
    return BookingEntity;
  }

  // entity to model
  public void entityPost(Booking bookingEntity) {
    if (bookingEntity != null) {

      UserModel uModel = new UserModel();
      uModel.entityPost(bookingEntity.getUser());
      setUserModel(uModel);

      ListingModel lModel = new ListingModel();
      lModel.entityPost(bookingEntity.getListing());
      setListingModel(lModel);
    }
  }

}

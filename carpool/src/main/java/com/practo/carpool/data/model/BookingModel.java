/**
 * 
 */
package com.practo.carpool.data.model;

import java.io.Serializable;

import com.practo.carpool.data.entity.Booking;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
public class BookingModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private int idBooking;

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
    if (this.getUserModel() != null) {
      BookingEntity.setUser(this.getUserModel().entityGet());
    }
    if (this.getListingModel() != null) {
      BookingEntity.setListing(this.getListingModel().entityGet());
    }
    if (new Integer(getIdBooking()) != null)
      BookingEntity.setIdBooking(getIdBooking());
    return BookingEntity;
  }

  // entity to model
  public void entityPost(Booking bookingEntity) throws NotFoundException {
    if (bookingEntity != null && bookingEntity.getDeletedAt() == null) {
      this.setIdBooking(bookingEntity.getIdBooking());
      UserModel uModel = new UserModel();
      try {
        uModel.entityPost(bookingEntity.getUser());
        this.setUserModel(uModel);
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }

      ListingModel lModel = new ListingModel();
      try {
        lModel.entityPost(bookingEntity.getListing());
        setListingModel(lModel);
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }
    } else {
      throw new NotFoundException("Booking with given id doesn't exist");
    }
  }

}

/**
 * 
 */
package com.practo.carpool.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.practo.carpool.data.entity.Address;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
public class AddressModel implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private int id;

  private BigDecimal latitude;

  private BigDecimal longitude;

  private String destination;

  public AddressModel() {}

  public AddressModel(BigDecimal latitude, BigDecimal longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
  
  

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public String getDestination(){
    return destination;
  }
  
  public void setDestination(String destination){
    this.destination = destination;
  }

  public BigDecimal getLatitude() {
    return this.latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return this.longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  // model to entity
  public Address entityGet() {
    Address addressEntity = new Address();
    addressEntity.setLatitude(getLatitude());
    addressEntity.setLongitude(getLongitude());
    addressEntity.setDestination(getDestination());
    if (new Integer(getId()) != null)
      addressEntity.setId(getId());
    return addressEntity;
  }

  // entity to model
  public void entityPost(Address addressEntity) throws NotFoundException {
    if (addressEntity != null && addressEntity.getDeletedAt() == null) {
      setId(addressEntity.getId());
      setLatitude(addressEntity.getLatitude());
      setLongitude(addressEntity.getLongitude());
      setDestination(addressEntity.getDestination());
    } else {
      throw new NotFoundException("Address with given id doesn't exist");
    }
  }
}

/**
 * 
 */
package com.practo.carpool.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.practo.carpool.data.entity.Address;

/**
 * @author aditya
 *
 */
public class AddressModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private byte active;

  private String administrativeAreaLevel1;

  private String administrativeAreaLevel2;

  private String country;

  private Date createdAt;

  private Date deletedAt;

  private BigDecimal latitude;

  private BigDecimal longitude;

  private Date modifiedAt;

  private String neighbourhood;

  private String postalCode;

  private String route;

  private String streetNumber;

  private String sublocality;

  public AddressModel() {}

  public AddressModel(BigDecimal latitude, BigDecimal longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
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

  public String getAdministrativeAreaLevel1() {
    return this.administrativeAreaLevel1;
  }

  public void setAdministrativeAreaLevel1(String administrativeAreaLevel1) {
    this.administrativeAreaLevel1 = administrativeAreaLevel1;
  }

  public String getAdministrativeAreaLevel2() {
    return this.administrativeAreaLevel2;
  }

  public void setAdministrativeAreaLevel2(String administrativeAreaLevel2) {
    this.administrativeAreaLevel2 = administrativeAreaLevel2;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
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

  public Date getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public String getNeighbourhood() {
    return this.neighbourhood;
  }

  public void setNeighbourhood(String neighbourhood) {
    this.neighbourhood = neighbourhood;
  }

  public String getPostalCode() {
    return this.postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getRoute() {
    return this.route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  public String getStreetNumber() {
    return this.streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public String getSublocality() {
    return this.sublocality;
  }

  public void setSublocality(String sublocality) {
    this.sublocality = sublocality;
  }

  // model to entity
  public Address entityGet() {
    Address addressEntity = new Address();
    addressEntity.setLatitude(getLatitude());
    addressEntity.setLongitude(getLongitude());
    if (new Integer(getId()) != null)
      addressEntity.setId(getId());
    return addressEntity;
  }

  // entity to model
  public void entityPost(Address addressEntity) {
    if (addressEntity != null) {
      setLongitude(addressEntity.getLongitude());
      setLatitude(addressEntity.getLatitude());
    }

  }
}

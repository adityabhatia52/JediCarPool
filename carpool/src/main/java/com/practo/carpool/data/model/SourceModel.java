/**
 * 
 */
package com.practo.carpool.data.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author aditya
 *
 */
public class SourceModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private byte active;

  private String address;

  private Date createdAt;

  private Date deletedAt;

  private Date modifiedAt;

  private String nameOffice;

  public SourceModel() {}

  public SourceModel(String address, String nameOffice, List<ListingModel> listingsModel) {
    this.address = address;
    this.nameOffice = nameOffice;
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

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  public String getNameOffice() {
    return this.nameOffice;
  }

  public void setNameOffice(String nameOffice) {
    this.nameOffice = nameOffice;
  }


}

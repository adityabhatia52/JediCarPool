/**
 * 
 */
package com.practo.carpool.data.model;

import java.io.Serializable;

import com.practo.carpool.data.entity.Source;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
public class SourceModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private String address;

  private String nameOffice;

  public SourceModel() {}

  public SourceModel(String address, String nameOffice) {
    this.address = address;
    this.nameOffice = nameOffice;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getNameOffice() {
    return this.nameOffice;
  }

  public void setNameOffice(String nameOffice) {
    this.nameOffice = nameOffice;
  }

  // model to entity
  public Source entityGet() {
    Source sourceEntity = new Source();
    sourceEntity.setAddress(getAddress());
    sourceEntity.setNameOffice(getNameOffice());
    if (new Integer(getId()) != null)
      sourceEntity.setId(getId());
    return sourceEntity;
  }

  // entity to model
  public void entityPost(Source e) throws NotFoundException {
    if (e != null && e.getDeletedAt() == null) {
      setNameOffice(e.getNameOffice());
      setAddress(e.getAddress());
      setId(e.getId());
    }
    else
    {
      throw new NotFoundException("Source with given id doesn't exist");
    }
  }

}

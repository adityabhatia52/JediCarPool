/**
* 
*/
package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Address;
import com.practo.carpool.data.model.AddressModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.repository.AddressRepository;

/**
 * @author aditya
 *
 */
@Service
public class AddressServiceImplement implements AddressService {
  @Autowired
  private AddressRepository addressRepo;

  @Override
  public Iterable<AddressModel> get() {
    Iterable<Address> entities = addressRepo.findAll();
    ArrayList<AddressModel> ulist = new ArrayList<AddressModel>();
    for (Address entity : entities) {
      AddressModel u = new AddressModel();
      try {
        u.entityPost(entity);
        ulist.add(u);
      } catch (NotFoundException e) {
        // Nothing needs to be done on accessing an deleted entity because the deleted entity won't
        // be added to the list
      }
    }
    return ulist;
  }

  @Override
  public AddressModel get(int id) throws NotFoundException {
    // TODO Auto-generated method stub
    Address entity = addressRepo.findOne(id);
    AddressModel addModel = new AddressModel();
    addModel.entityPost(entity);
    return addModel;
  }
 
  @Override
  @Transactional
  public AddressModel create(AddressModel addModel) {
    Address entity = new Address();
    try {
      entity = addModel.entityGet();
      entity.setCreatedAt(new Date());
      addressRepo.save(entity); 
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
    return addModel;
  }

  @Override
  @Transactional
  public AddressModel update(AddressModel addModel, int id) throws NotFoundException {
    if (addressRepo.findOne(id).getDeletedAt() == null) {
      addModel.setId(id);
      Address entity = addModel.entityGet();
      entity.setModifiedAt(new Date());
      try {
        entity = addressRepo.save(entity);
        addModel.entityPost(entity);
      } catch (NotFoundException e) {
        e.printStackTrace();
      }
      return addModel;
    } else {
      throw new NotFoundException("Address with given id doesn't exist");
    }
  }


  @Override
  public void delete(int id) throws NotFoundException {
    try {
      Address addressEntity = addressRepo.findOne(id);
      addressEntity.setDeletedAt(new Date());
    } catch (ObjectNotFoundException e) {
      throw new NotFoundException("Address with the given id doesn't exist");
    }
  }

}

/**
 * 
 */
package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Address;
import com.practo.carpool.data.model.AddressModel;
import com.practo.carpool.repository.AddressRepository;

/**
 * @author aditya
 *
 */
@Service
@Transactional
public class AddressServiceImplement implements AddressService {
  @Autowired
  private AddressRepository addressRepo;

  @Override
  public Iterable<AddressModel> get() {
    // TODO Auto-generated method stub
    Iterable<Address> entities = addressRepo.findAll();
    List<AddressModel> ulist = new ArrayList<AddressModel>();
    for (Address entity : entities) {
      AddressModel u = new AddressModel();
      u.entityPost(entity);
      ulist.add(u);
    }
    return ulist;
  }

  @Override
  public AddressModel get(int id) {
    // TODO Auto-generated method stub
    Address entity = addressRepo.findOne(id);
    AddressModel addModel = new AddressModel();
    addModel.entityPost(entity);
    return addModel;
  }

  @Override
  public AddressModel create(AddressModel addModel) {
    // TODO Auto-generated method stub
    Address entity = new Address();
    entity = addModel.entityGet();
    addressRepo.save(entity);
    return addModel;
  }

  @Override
  public AddressModel update(AddressModel addModel, int id) {
    // TODO Auto-generated method stub
    Address entity = new Address();
    entity = addModel.entityGet();
    addressRepo.delete(id);
    addressRepo.save(entity);
    addModel.entityPost(entity);
    return addModel;
  }


  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    addressRepo.delete(id);
  }

}

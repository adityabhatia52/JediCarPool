package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Vehicle;
import com.practo.carpool.data.model.VehicleModel;
import com.practo.carpool.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImplement implements VehicleService {
  @Autowired
  private VehicleRepository VehicleRepo;

  @Override
  public Iterable<VehicleModel> get() {
    Iterable<Vehicle> entities = VehicleRepo.findAll();
    List<VehicleModel> ulist = new ArrayList<VehicleModel>();
    for (Vehicle entity : entities) {
      VehicleModel u = new VehicleModel();
      u.entityPost(entity);
      ulist.add(u);
    }
    return ulist;
  }

  @Override
  public VehicleModel get(int id) {
    Vehicle entity = VehicleRepo.findOne(id);
    VehicleModel um = new VehicleModel();
    um.entityPost(entity);
    return um;
  }

  @Override
  public VehicleModel create(VehicleModel VehicleModel) {
    Vehicle entity = new Vehicle();
    entity = VehicleModel.entityGet();
    VehicleRepo.save(entity);
    return VehicleModel;
  }

  @Override
  public VehicleModel update(VehicleModel VehicleModel, int id) {
    Vehicle entity = new Vehicle();
    entity = VehicleModel.entityGet();
    VehicleRepo.delete(id);
    VehicleRepo.save(entity);
    VehicleModel.entityPost(entity);
    return VehicleModel;
  }

  @Override
  public void delete(int id) {
    VehicleRepo.delete(id);
    // SET DELETED AT
  }

}

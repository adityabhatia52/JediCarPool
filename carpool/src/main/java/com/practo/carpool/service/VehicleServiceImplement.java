package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Vehicle;
import com.practo.carpool.data.model.UserModel;
import com.practo.carpool.data.model.VehicleModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImplement implements VehicleService {
  @Autowired
  private VehicleRepository VehicleRepo;

  @Override
  public Iterable<VehicleModel> get(int userId) {
    Iterable<Vehicle> entities = VehicleRepo.findByUserId(userId);
    List<VehicleModel> ulist = new ArrayList<VehicleModel>();
    for (Vehicle entity : entities) {
      VehicleModel u = new VehicleModel();
      try {
        u.entityPost(entity);
        ulist.add(u);
      } catch (NotFoundException e) {
      }
      // The try-catch block is triggered when accessing a deleted entity. Nothing needs to be done
      // on accessing a deleted entity
    }
    return ulist;
  }

  @Override
  public VehicleModel get(int UserId, int id) throws NotFoundException {
    Vehicle entity = VehicleRepo.findByUserIdAndId(UserId, id);
    VehicleModel um = new VehicleModel();
    um.entityPost(entity);
    return um;
  }

  @Override
  public VehicleModel create(int UserId, VehicleModel VehicleModel) {
    Vehicle entity = new Vehicle();
    UserModel userModel = new UserModel();
    userModel.setId(UserId);
    VehicleModel.setUserModel(userModel);
    entity = VehicleModel.entityGet();
    entity.setCreatedAt(new Date());
    try {
      VehicleRepo.save(entity);
      VehicleModel.entityPost(entity);
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
    return VehicleModel;
  }

  @Override
  public VehicleModel update(int UserId, VehicleModel VehicleModel, int id)
      throws NotFoundException {
    if (VehicleRepo.findOne(id).getDeletedAt() == null) {
      UserModel userModel = new UserModel();
      userModel.setId(UserId);
      VehicleModel.setUserModel(userModel);
      VehicleModel.setId(id);
      Vehicle entity = new Vehicle();
      entity = VehicleModel.entityGet();
      entity.setModifiedAt(new Date());
      try {
        entity = VehicleRepo.save(entity);
        VehicleModel.entityPost(entity);
      } catch (NotFoundException e) {
        e.printStackTrace();
      }
      return VehicleModel;
    } else {
      throw new NotFoundException("Vehicle with the given id doesn't exist");
    }
  }

  @Override
  public void delete(int UserId, int id) throws NotFoundException {
    try {
      Vehicle vehicleEntity = VehicleRepo.findOne(id);
      vehicleEntity.setDeletedAt(new Date());
    } catch (ObjectNotFoundException e) {
      throw new NotFoundException("Vehicle with the given id doesn't exist");
    }
  }

}

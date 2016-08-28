package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.User;
import com.practo.carpool.data.model.UserModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.repository.UserRepository;

@Service
@Transactional
public class UserServiceImplement implements UserService {
  @Autowired
  private UserRepository userRepo;

  @Override
  public Iterable<UserModel> get() {
    Iterable<User> entities = userRepo.findAll();
    List<UserModel> ulist = new ArrayList<UserModel>();
    for (User entity : entities) {
      UserModel u = new UserModel();
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
  public UserModel get(int id) throws NotFoundException {
    try{
      User entity = userRepo.findOne(id);
      UserModel um = new UserModel();
      um.entityPost(entity);
      return um;
    }
    catch (ObjectNotFoundException e) {
      throw new NotFoundException("User with the given id doesn't exist");
    }
  }

  @Override
  @Transactional
  public UserModel create(UserModel userModel) {
    User entity = new User();
    entity = userModel.entityGet();
    entity.setCreatedAt(new Date());
    try {
      entity = userRepo.save(entity);
      userModel.entityPost(entity);
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
    return userModel;
  }

  @Override
  public UserModel update(UserModel userModel, int id) throws NotFoundException {
    try {
      userRepo.findOne(id);
    } catch (ObjectNotFoundException e) {
      throw new NotFoundException("User with the given id doesn't exist");
    }
    if (userRepo.findOne(id).getDeletedAt() == null) {
      User entity = new User();
      entity = userModel.entityGet();
      entity.setId(id);
      entity.setModifiedAt(new Date());
      try {
        entity = userRepo.save(entity);
        userModel.entityPost(entity);
      } catch (NotFoundException e) {
        e.printStackTrace();
      }
      return userModel;
    } else {
      throw new NotFoundException("User with the given id doesn't exist");
    }
  }

  @Override
  public void delete(int id) throws NotFoundException {
    try {
      User userEntity = userRepo.findOne(id);
      userEntity.setDeletedAt(new Date());
    } catch (ObjectNotFoundException e) {
      throw new NotFoundException("User with the given id doesn't exist");
    }
  }

}

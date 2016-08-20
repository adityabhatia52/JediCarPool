package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.User;
import com.practo.carpool.data.model.UserModel;
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
      u.entityPost(entity);
      ulist.add(u);
    }
    return ulist;
  }
  
  @Override
  public UserModel get(int id) {
    User entity = userRepo.findOne(id);
    UserModel um = new UserModel();
    um.entityPost(entity);
    return um;
  }

  @Override
  public UserModel create(UserModel userModel) {
    User entity = new User();
    entity = userModel.entityGet();
    userRepo.save(entity);
    return userModel;
  }

  @Override
  public UserModel update(UserModel userModel, int id) {
    User entity = new User();
    entity = userModel.entityGet();
    entity.setId(id);
    userRepo.save(entity);
    userModel.entityPost(entity);
    return userModel;
  }

  @Override
  public void delete(int id) {
    userRepo.delete(id);
    // SET DELETED AT
  }

}

package com.practo.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.carpool.data.model.UserModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userServe;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<UserModel> get() {
    return userServe.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<UserModel> create(@RequestBody UserModel um) {
    UserModel newUm = new UserModel();
    newUm = userServe.create(um);
    ResponseEntity<UserModel> response = new ResponseEntity<UserModel>(newUm, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public UserModel get(@PathVariable("id") int id) throws NotFoundException {
    return userServe.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<UserModel> update(@PathVariable("id") int id, @RequestBody UserModel user)
      throws NotFoundException {
    UserModel aModel = userServe.update(user, id);
    ResponseEntity<UserModel> response = new ResponseEntity<UserModel>(aModel, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) throws NotFoundException {
    userServe.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }
}


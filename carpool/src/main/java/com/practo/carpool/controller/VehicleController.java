/**
 * 
 */
package com.practo.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.carpool.data.model.VehicleModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.service.VehicleService;

/**
 * @author aditya
 *
 */
@RestController
@RequestMapping("/user/{user_id}/vehicle")
public class VehicleController {

  @Autowired
  private VehicleService vehicleServe;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<VehicleModel> get(@PathVariable("user_id") int userId) {
    return vehicleServe.get(userId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<VehicleModel> create(@PathVariable("user_id") int userId,
      @RequestBody VehicleModel um) {
    VehicleModel newUm = new VehicleModel();
    newUm = vehicleServe.create(userId, um);
    ResponseEntity<VehicleModel> response =
        new ResponseEntity<VehicleModel>(newUm, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public VehicleModel get(@PathVariable("id") int id, @PathVariable("user_id") int userId)
      throws NotFoundException {
    return vehicleServe.get(userId, id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<VehicleModel> update(@PathVariable("user_id") int userId,
      @PathVariable("id") int id, @RequestBody VehicleModel vehicle) throws NotFoundException {
    VehicleModel aModel = vehicleServe.update(userId, vehicle, id);
    ResponseEntity<VehicleModel> response = new ResponseEntity<VehicleModel>(aModel, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("user_id") int userId,
      @PathVariable("id") int id) throws NotFoundException {
    vehicleServe.delete(userId, id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }
}

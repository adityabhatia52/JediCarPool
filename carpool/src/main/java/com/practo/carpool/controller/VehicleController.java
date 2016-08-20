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
import com.practo.carpool.service.VehicleService;

/**
 * @author aditya
 *
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

  @Autowired
  private VehicleService vehicleServe;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<VehicleModel> get() {
    return vehicleServe.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<VehicleModel> create(@RequestBody VehicleModel um) {
    VehicleModel newUm = new VehicleModel();
    newUm = vehicleServe.create(um);
    ResponseEntity<VehicleModel> response = new ResponseEntity<VehicleModel>(newUm, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public VehicleModel get(@PathVariable("id") int id) {
    return vehicleServe.get(id);
  }

/*  @RequestMapping(method = RequestMethod.PUT)
  public ResponseEntity<vehicleModel> update(@RequestBody vehicleModel um, int id) {
    vehicle u = repository.save(vehicle);
    ResponseEntity<vehicle> response = new ResponseEntity<vehicle>(u, HttpStatus.OK);
    return response;
  }*/

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    vehicleServe.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }
}

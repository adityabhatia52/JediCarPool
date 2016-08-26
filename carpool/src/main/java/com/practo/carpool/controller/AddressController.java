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

import com.practo.carpool.data.model.AddressModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.service.AddressService;

/**
 * @author aditya
 *  Controller for address Entity with GET;POST;PUT and DELETE
 */
@RestController
@RequestMapping("/address")
public class AddressController {

  @Autowired
  private AddressService addressServe;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<AddressModel> get() {
    return addressServe.get();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public AddressModel get(@PathVariable("id") int id) throws NotFoundException {
    return addressServe.get(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<AddressModel> create(@RequestBody AddressModel um) {
    AddressModel newUm = new AddressModel();
    newUm = addressServe.create(um);
    ResponseEntity<AddressModel> response =
        new ResponseEntity<AddressModel>(newUm, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<AddressModel> update(@PathVariable("id") int id,
      @RequestBody AddressModel address) throws NotFoundException{
    AddressModel aModel = addressServe.update(address,id);
    ResponseEntity<AddressModel> response = new ResponseEntity<AddressModel>(aModel, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) throws NotFoundException{
    addressServe.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }
}

package com.practo.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.carpool.data.model.ListingModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.service.ListingService;

@RestController
@RequestMapping("/listing")
public class ListingController {

  @Autowired
  private ListingService listingServe;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<ListingModel> get(Pageable pageable) {
    return listingServe.get(pageable);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<ListingModel> create(@RequestBody ListingModel um) {
    ListingModel newUm = new ListingModel();
    newUm = listingServe.create(um);
    ResponseEntity<ListingModel> response =
        new ResponseEntity<ListingModel>(newUm, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ListingModel get(@PathVariable("id") int id) throws NotFoundException {
    return listingServe.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<ListingModel> update(@PathVariable("id") int id,
      @RequestBody ListingModel listing) throws NotFoundException {
    ListingModel aModel = listingServe.update(listing, id);
    ResponseEntity<ListingModel> response = new ResponseEntity<ListingModel>(aModel, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) throws NotFoundException {
    listingServe.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }
}

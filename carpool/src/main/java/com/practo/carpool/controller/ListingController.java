package com.practo.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.carpool.data.model.ListingModel;
import com.practo.carpool.service.ListingService;

@RestController
@RequestMapping("/lisiting")
public class ListingController {

  @Autowired
  private ListingService lisitingServe;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<ListingModel> get() {
    return lisitingServe.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<ListingModel> create(@RequestBody ListingModel um) {
    ListingModel newUm = new ListingModel();
    newUm = lisitingServe.create(um);
    ResponseEntity<ListingModel> response =
        new ResponseEntity<ListingModel>(newUm, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ListingModel get(@PathVariable("id") int id) {
    return lisitingServe.get(id);
  }

  /*
   * @RequestMapping(method = RequestMethod.PUT) public ResponseEntity<lisitingModel>
   * update(@RequestBody lisitingModel um, int id) { lisiting u = repository.save(lisiting);
   * ResponseEntity<lisiting> response = new ResponseEntity<lisiting>(u, HttpStatus.OK); return
   * response; }
   */

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    lisitingServe.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }
}

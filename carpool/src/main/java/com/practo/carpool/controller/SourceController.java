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

import com.practo.carpool.data.model.SourceModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.service.SourceService;

/**
 * @author aditya
 *
 */
@RestController
@RequestMapping("/source")
public class SourceController {

  @Autowired
  private SourceService sourceServe;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<SourceModel> get() {
    return sourceServe.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<SourceModel> create(@RequestBody SourceModel um) {
    SourceModel newUm = new SourceModel();
    newUm = sourceServe.create(um);
    ResponseEntity<SourceModel> response =
        new ResponseEntity<SourceModel>(newUm, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public SourceModel get(@PathVariable("id") int id) throws NotFoundException {
    return sourceServe.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<SourceModel> update(@PathVariable("id") int id,
      @RequestBody SourceModel source) throws NotFoundException {
    SourceModel sModel = sourceServe.update(source, id);
    ResponseEntity<SourceModel> response = new ResponseEntity<SourceModel>(sModel, HttpStatus.OK);
    return response;
  }


  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) throws NotFoundException {
    sourceServe.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }
}

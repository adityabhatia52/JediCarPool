package com.practo.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.carpool.data.model.BookingModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.service.BookingService;

@RestController
@RequestMapping("/listing/{listing_id}/booking")
public class BookingController {

  @Autowired
  private BookingService bookingServe;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<BookingModel> get(@PathVariable("listing_id") int listId) {
    return bookingServe.get(listId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<BookingModel> create(@PathVariable("listing_id") int listId,
      @RequestBody BookingModel um) {
    BookingModel newUm = new BookingModel();
    newUm = bookingServe.create(listId, um);
    ResponseEntity<BookingModel> response =
        new ResponseEntity<BookingModel>(newUm, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public BookingModel get(@PathVariable("listing_id") int listId, @PathVariable("id") int id)
      throws NotFoundException {
    return bookingServe.get(listId, id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<BookingModel> update(@PathVariable("listing_id") int listId,
      @PathVariable("id") int id, @RequestBody BookingModel booking) throws NotFoundException {
    BookingModel aModel = bookingServe.update(listId, booking, id);
    ResponseEntity<BookingModel> response = new ResponseEntity<BookingModel>(aModel, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("listing_id") int listId,
      @PathVariable("id") int id) throws NotFoundException {
    bookingServe.delete(listId, id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }
}

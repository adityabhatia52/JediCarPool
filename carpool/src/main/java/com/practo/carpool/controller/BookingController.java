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
import com.practo.carpool.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

  @Autowired
  private BookingService bookingServe;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<BookingModel> get() {
    return bookingServe.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<BookingModel> create(@RequestBody BookingModel um) {
    BookingModel newUm = new BookingModel();
    newUm = bookingServe.create(um);
    ResponseEntity<BookingModel> response =
        new ResponseEntity<BookingModel>(newUm, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public BookingModel get(@PathVariable("id") int id) {
    return bookingServe.get(id);
  }

  /*
   * @RequestMapping(method = RequestMethod.PUT) public ResponseEntity<bookingModel>
   * update(@RequestBody bookingModel um, int id) { booking u = repository.save(booking);
   * ResponseEntity<booking> response = new ResponseEntity<booking>(u, HttpStatus.OK); return
   * response; }
   */

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    bookingServe.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }
}

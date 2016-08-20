/**
 * 
 */
package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Booking;
import com.practo.carpool.data.model.BookingModel;
import com.practo.carpool.repository.BookingRepository;

/**
 * @author aditya
 *
 */
@Service
@Transactional
public class BookingServiceImplement implements BookingService {

  @Autowired
  private BookingRepository bookingRepo;

  @Override
  public Iterable<BookingModel> get() {
    Iterable<Booking> entities = bookingRepo.findAll();
    List<BookingModel> ulist = new ArrayList<BookingModel>();
    for (Booking entity : entities) {
      BookingModel u = new BookingModel();
      u.entityPost(entity);
      ulist.add(u);
    }
    return ulist;
  }

  @Override
  public BookingModel get(int id) {
    Booking entity = bookingRepo.findOne(id);
    BookingModel um = new BookingModel();
    um.entityPost(entity);
    return um;
  }

  @Override
  public BookingModel create(BookingModel bookingModel) {
    Booking entity = new Booking();
    entity = bookingModel.entityGet();
    bookingRepo.save(entity);
    return bookingModel;
  }

  @Override
  public BookingModel update(BookingModel bookingModel, int id) {
    Booking entity = new Booking();
    entity = bookingModel.entityGet();
    entity.setIdBooking(id);
    bookingRepo.save(entity);
    bookingModel.entityPost(entity);
    return bookingModel;
  }

  @Override
  public void delete(int id) {
    bookingRepo.delete(id);
    // SET DELETED AT
  }


}

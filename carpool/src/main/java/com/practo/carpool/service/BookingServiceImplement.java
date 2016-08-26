/**
 * 
 */
package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Booking;
import com.practo.carpool.data.model.BookingModel;
import com.practo.carpool.data.model.ListingModel;
import com.practo.carpool.exceptions.NotFoundException;
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
  public Iterable<BookingModel> get(int listId) {
    Iterable<Booking> entities = bookingRepo.findByListingId(listId);
    List<BookingModel> ulist = new ArrayList<BookingModel>();
    for (Booking entity : entities) {
      BookingModel u = new BookingModel();
      try {
        u.entityPost(entity);
        ulist.add(u);
      } catch (NotFoundException e) {
        // Nothing needs to be done on accessing an deleted entity because the deleted entity won't
        // be added to the list
      }
    }
    return ulist;
  }

  @Override
  public BookingModel get(int listId, int id) throws NotFoundException {
    Booking entity = bookingRepo.findByListingIdAndId(listId, id);
    BookingModel um = new BookingModel();
    um.entityPost(entity);
    return um;
  }

  @Override
  public BookingModel create(int listId, BookingModel bookingModel) {
    ListingModel listModel = new ListingModel();
    listModel.setId(listId);
    bookingModel.setListingModel(listModel);
    Booking entity = new Booking();
    entity = bookingModel.entityGet();
    try {
      entity.setCreatedAt(new Date());
      bookingRepo.save(entity);
      bookingModel.entityPost(entity);
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
    return bookingModel;
  }

  @Override
  public BookingModel update(int listId, BookingModel bookingModel, int id)
      throws NotFoundException {
    if (bookingRepo.findOne(id).getDeletedAt() == null) {
      ListingModel listModel = new ListingModel();
      listModel.setId(listId);
      bookingModel.setListingModel(listModel);
      bookingModel.setIdBooking(id);
      Booking entity = new Booking();
      entity = bookingModel.entityGet();
      entity.setModifiedAt(new Date());
      entity.setIdBooking(id);
      try {
        bookingRepo.save(entity);
        bookingModel.entityPost(entity);
      } catch (NotFoundException e) {
        e.printStackTrace();
      }
      return bookingModel;
    } else {
      throw new NotFoundException("Booking with the given id doesn't exist");
    }
  }

  @Override
  public void delete(int listId, int id) throws NotFoundException {
    try {
      Booking bookingEntity = bookingRepo.findOne(id);
      bookingEntity.setDeletedAt(new Date());
    } catch (ObjectNotFoundException e) {
      throw new NotFoundException("Booking with the given id doesn't exist");
    }
  }
}

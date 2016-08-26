/**
 * 
 */
package com.practo.carpool.service;

import com.practo.carpool.data.model.BookingModel;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
public interface BookingService {

  public Iterable<BookingModel> get(int listId);

  public BookingModel get(int listId,int id) throws NotFoundException;

  public BookingModel create(int listId,BookingModel bookingModel);

  public BookingModel update(int listId,BookingModel bookingModel, int id) throws NotFoundException; 

  public void delete(int listId,int id) throws NotFoundException;

}

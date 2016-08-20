/**
 * 
 */
package com.practo.carpool.service;

import com.practo.carpool.data.model.BookingModel;

/**
 * @author aditya
 *
 */
public interface BookingService {

  public Iterable<BookingModel> get();

  public BookingModel get(int id);

  public BookingModel create(BookingModel bookingModel);

  public BookingModel update(BookingModel bookingModel, int id);

  public void delete(int id);

}

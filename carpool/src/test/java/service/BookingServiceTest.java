package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.carpool.data.model.BookingModel;
import com.practo.carpool.data.model.UserModel;
import com.practo.carpool.data.model.VehicleModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.run.Application;
import com.practo.carpool.service.BookingService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BookingServiceTest {
  @Autowired
  private BookingService service;

  @Test
  public void testAGet() throws NotFoundException {
    // Get All Bookings
    ArrayList<BookingModel> bookingModel = (ArrayList<BookingModel>) service.get(1);
    assertEquals(2, bookingModel.size());
    assertEquals(1, bookingModel.get(0).getUserModel().getId());
    assertEquals(1, bookingModel.get(0).getListingModel().getId());
    assertEquals(1, bookingModel.get(0).getIdBooking());

    // Get One Booking
    BookingModel bookModel = service.get(1, 2);
    assertNotNull(bookModel);
    assertEquals(2, bookModel.getUserModel().getId());
  }

  // get for not found
  @Test(expected = NotFoundException.class)
  public void testBGetNotFound() throws NotFoundException {
    BookingModel bookingModel = service.get(1, 11);
    assertNull(bookingModel);
  }

  // create
  @Test
  public void testCreate() throws NotFoundException {
    BookingModel bookModel = new BookingModel();
    UserModel userModel = new UserModel();
    userModel.setId(1);
    bookModel.setUserModel(userModel);
    bookModel = service.create(1, bookModel);
    assertEquals(3, bookModel.getListingModel().getSeatAvailable());
    BookingModel dbBook = new BookingModel();
    dbBook = service.get(1, 4);
    assertNotNull(dbBook);
    assertEquals(1, dbBook.getListingModel().getId());
    assertEquals(4, dbBook.getIdBooking());
  }

  // update
  @Test
  public void testDUpdate() throws NotFoundException {
    BookingModel bookModel = new BookingModel();
    UserModel userModel = new UserModel();
    userModel.setId(1);
    bookModel.setUserModel(userModel);
    bookModel = service.update(1, bookModel, 2);
    assertEquals(1, bookModel.getUserModel().getId());
  }

  @Test(expected = NotFoundException.class)
  public void testDelete() throws NotFoundException{
    service.delete(1, 2);
    BookingModel bookModel = service.get(1, 2);
    assertNull(bookModel);
  }
}

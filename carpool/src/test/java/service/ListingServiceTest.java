package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.carpool.data.model.AddressModel;
import com.practo.carpool.data.model.ListingModel;
import com.practo.carpool.data.model.SourceModel;
import com.practo.carpool.data.model.UserModel;
import com.practo.carpool.data.model.VehicleModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.run.Application;
import com.practo.carpool.service.ListingService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ListingServiceTest {

  @Autowired
  private ListingService service;

  @Test
  public void testAGet() throws NotFoundException {
    // Get All Address
    PageRequest pageable = new PageRequest(0, 2);
    ArrayList<ListingModel> listModel = (ArrayList<ListingModel>) service.get(pageable);
    assertEquals(3, listModel.size());
    assertEquals(1, listModel.get(0).getAvailability());
    assertEquals(4, listModel.get(0).getSeatAvailable());
    assertEquals(1, listModel.get(0).getUserModel().getId());
    assertEquals(1, listModel.get(0).getVehicleModel().getId());
    assertEquals(1, listModel.get(0).getSourceModel().getId());
    assertEquals(1, listModel.get(0).getAddressModel().getId());


    // Get One
    ListingModel listingModel = service.get(2);
    assertEquals(1, listingModel.getAvailability());
    assertEquals(2, listingModel.getSeatAvailable());
    assertEquals(2, listingModel.getUserModel().getId());
    assertEquals(2, listingModel.getVehicleModel().getId());
    assertEquals(2, listingModel.getSourceModel().getId());
    assertEquals(1, listingModel.getAddressModel().getId());
  }

  // get for not found
  @Test(expected = NotFoundException.class)
  public void testBGetNotFound() throws NotFoundException {
    ListingModel listModel = service.get(11);
    assertNull(listModel);
  }

  // create
  /**test to check if listing service is being created or not.
   * @throws NotFoundException if the listing is not created successfully.
   */
  @Test
  public void testCreate() throws NotFoundException {
    UserModel userModel = new UserModel();
    userModel.setId(1);
    VehicleModel vehicleModel = new VehicleModel();
    vehicleModel.setId(1);
    SourceModel sourceModel = new SourceModel();
    sourceModel.setId(2);
    AddressModel addressModel = new AddressModel();
    addressModel.setId(1);
    addressModel.setLatitude(new BigDecimal("1.11000000"));
    addressModel.setLongitude(new BigDecimal("2.22000000"));
    ListingModel listingModel = new ListingModel();
    listingModel.setUserModel(userModel);
    listingModel.setVehicleModel(vehicleModel);
    listingModel.setSourceModel(sourceModel);
    listingModel.setAddressModel(addressModel);
    Timestamp timestamp = Timestamp.valueOf("2016-08-18 14:56:55");
    listingModel.setDepartTime(timestamp);
    listingModel.setSeatAvailable(1);
    
    listingModel = service.create(listingModel);

    ListingModel dbListing = service.get(4);
    assertNotNull(dbListing);
    assertEquals(1, dbListing.getUserModel().getId());
    assertEquals(1, dbListing.getVehicleModel().getId());
    assertEquals(2, dbListing.getSourceModel().getId());
    assertEquals(1, dbListing.getAddressModel().getId());
    assertEquals(1, dbListing.getSeatAvailable());
    assertEquals(timestamp, dbListing.getDepartTime());
  }



  // update
  @Test
  public void testDUpdate() throws NotFoundException {

    ListingModel listingModel = service.get(1);
    listingModel.setAvailability((byte) 0);
    listingModel.setSeatAvailable(6);
    
    service.update(listingModel, 1);

    ListingModel dbVehicle = service.get(1);
    assertNotNull(dbVehicle);
    assertEquals(6,dbVehicle.getSeatAvailable());
    assertEquals(0, dbVehicle.getAvailability());
  }

  // update not found
  @Test(expected = NotFoundException.class)
  public void testEUpdateNotFound() throws NotFoundException {
    ListingModel listingModel = service.get(10);
    listingModel.setSeatAvailable(12);

    service.update(listingModel, 10);
    assertNull(listingModel);
  }
  
  // delete
  @Test(expected = NotFoundException.class)
  public void testFDelete() throws NotFoundException {
    service.delete(4);
    ListingModel listModel = service.get(4);
    assertNull(listModel);   
    service.delete(5);
  }
  
  

}

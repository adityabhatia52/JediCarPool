package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.carpool.data.model.AddressModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.run.Application;
import com.practo.carpool.service.AddressService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AddressServiceTest {

  @Autowired
  private AddressService service;

  @Test
  public void testAGet() throws NotFoundException {
    // Get All Address
    ArrayList<AddressModel> Address = (ArrayList<AddressModel>) service.get();
    assertEquals(3, Address.size());
    assertEquals("JP Nagar, Banglore", Address.get(0).getDestination());
    assertEquals(new BigDecimal("1.11"), Address.get(0).getLongitude());
    assertEquals(new BigDecimal("1.22"), Address.get(0).getLatitude());
    // Get One
    AddressModel addressModel = service.get(2);
    assertEquals("Bannerghatta Road, Banglore", addressModel.getDestination());
    assertEquals(new BigDecimal("3.11"), addressModel.getLongitude());
    assertEquals(new BigDecimal("4.22"), addressModel.getLatitude());
  }

  // get for not found
  @Test(expected = NotFoundException.class)
  public void testBGetNotFound() throws NotFoundException {
    AddressModel AddressModel = service.get(11);
    assertNull(AddressModel);
  }

  // create
  @Test
  public void testCreate() throws NotFoundException {
    AddressModel address = new AddressModel();
    address.setDestination("IIM Banglore");
    address.setLongitude(new BigDecimal("2.22"));
    address.setLatitude(new BigDecimal("2.32"));
    address = service.create(address);
    AddressModel dbAddress = service.get(4);
    assertNotNull(dbAddress);
    assertEquals("IIM Banglore", dbAddress.getDestination());
    assertEquals(new BigDecimal("2.22"), dbAddress.getLongitude());
    assertEquals(new BigDecimal("2.32"), dbAddress.getLatitude());
  }

  // update
  @Test
  public void testDUpdate() throws NotFoundException {
    AddressModel addressModel = new AddressModel();
    addressModel = service.get(4);
    addressModel.setDestination("IIM Lucknow");

    service.update(addressModel, 4);

    AddressModel dbAddress = service.get(4);
    assertNotNull(dbAddress);
    assertEquals("IIM Lucknow", dbAddress.getDestination());
    assertEquals(new BigDecimal("2.22"), dbAddress.getLongitude());
  }

  @Test(expected = NotFoundException.class)
  public void testEUpdateNotFound() throws NotFoundException {
    AddressModel addressModel = new AddressModel();
    addressModel = service.get(5);
    addressModel.setDestination("IIM Lucknow");
    service.update(addressModel, 5);
    AddressModel dbAddress = service.get(5);
    assertNull(dbAddress);  
  }
  
  @Test(expected = NotFoundException.class)
  public void testFDelete() throws NotFoundException {
    service.delete(4);
    AddressModel addressModel = service.get(4);
    assertNull(addressModel);
  }
}

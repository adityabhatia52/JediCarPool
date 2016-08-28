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

import com.practo.carpool.data.model.VehicleModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.run.Application;
import com.practo.carpool.service.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BVehicleServiceTest {

  @Autowired
  private VehicleService service;

  @Test
  public void testAGet() throws NotFoundException {
    // Get All Vehicles of user with id 1
    ArrayList<VehicleModel> vehicles = (ArrayList<VehicleModel>) service.get(1);
    assertEquals(2, vehicles.size());
    assertEquals("Aditya", vehicles.get(0).getUserModel().getName());
    assertEquals("Nano", vehicles.get(0).getModel());
    assertEquals("Nano2348", vehicles.get(0).getNumberPlate());
    assertEquals(4, vehicles.get(0).getCapacity());

    // Get One
    VehicleModel vehicleModel = service.get(2, 3);
    //assertEquals("Ankit", vehicleModel.getUserModel().getName());
    assertEquals("Bullet", vehicleModel.getModel());
    assertEquals("UP16F0203", vehicleModel.getNumberPlate());
    assertEquals(2, vehicleModel.getCapacity());

  }


  @Test(expected = NotFoundException.class)
  public void testBGetNotFound() throws NotFoundException {
    VehicleModel vehicleModel = service.get(1, 11);
    assertNull(vehicleModel);
  }
  // Create

  @Test
  public void testCreate() throws NotFoundException {
    VehicleModel vehicle = new VehicleModel();
    vehicle.setModel("Maruti");
    vehicle.setCapacity(3);
    vehicle.setNumberPlate("DL21G0202");
    vehicle = service.create(1, vehicle);
    VehicleModel dbVehicle = service.get(1, 4);
    assertNotNull(dbVehicle);
    assertEquals("Maruti", dbVehicle.getModel());
    assertEquals("DL21G0202", dbVehicle.getNumberPlate());
    assertEquals(3, dbVehicle.getCapacity());
  }

  // update

  @Test
  public void testDUpdate() throws NotFoundException {
    int userId = 2;
    int vehicleId = 3;
    VehicleModel vehicleModel = service.get(userId, vehicleId);
    vehicleModel.setModel("Gun");

    service.update(userId, vehicleModel, vehicleId);

    VehicleModel dbVehicle = service.get(userId, vehicleId);
    assertNotNull(dbVehicle);
    assertEquals("Gun", dbVehicle.getModel());
    assertEquals(2, dbVehicle.getCapacity());

  }

  @Test(expected = NotFoundException.class)
  public void testEUpdateNotFound() throws NotFoundException {
    VehicleModel vehicleModel = service.get(1, 10);
    vehicleModel.setModel("Hyundai");

    service.update(1, vehicleModel, 10);
    assertNull(vehicleModel);
  }

  // delete

  @Test(expected = NotFoundException.class)
  public void testFDelete() throws NotFoundException {
    service.delete(1, 1);
    VehicleModel vehicle = service.get(1, 1);
    assertNull(vehicle);
  }

}

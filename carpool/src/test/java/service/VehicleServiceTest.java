package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.carpool.data.model.VehicleModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.run.Application;
import com.practo.carpool.service.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class VehicleServiceTest {

  @Autowired
  private VehicleService service;

  @Test
  public void testGet() throws NotFoundException {
    // Get All Vehicles of user with id 1
    ArrayList<VehicleModel> Vehicles = (ArrayList<VehicleModel>) service.get(1);
    assertEquals(2, Vehicles.size());
    assertEquals("Aditya", Vehicles.get(0).getUserModel().getName());
    assertEquals("Nano", Vehicles.get(0).getModel());
    assertEquals("Nano2348", Vehicles.get(0).getNumberPlate());
    assertEquals(4, Vehicles.get(0).getCapacity());

    // Get One
    VehicleModel vehicleModel = service.get(2, 3);
    assertEquals("Ankit", vehicleModel.getUserModel().getName());
    assertEquals("Bullet", vehicleModel.getModel());
    assertEquals("UP16F0203", vehicleModel.getNumberPlate());
    assertEquals(2, vehicleModel.getCapacity());

  }


  @Test(expected = NotFoundException.class)
  public void testGetNotFound() throws NotFoundException {
    VehicleModel VehicleModel = service.get(1, 11);
    assertNull(VehicleModel);
  }
  // Create

  @Test
  public void testCreate() throws NotFoundException {
    VehicleModel Vehicle = new VehicleModel();
    Vehicle.setModel("Maruti");
    Vehicle.setCapacity(3);
    Vehicle.setNumberPlate("DL21G0202");
    Vehicle = service.create(1, Vehicle);
    VehicleModel dbVehicle = service.get(1, 4);
    assertNotNull(dbVehicle);
    assertEquals("Maruti", dbVehicle.getModel());
    assertEquals("DL21G0202", dbVehicle.getNumberPlate());
    assertEquals(3, dbVehicle.getCapacity());
  }

  // update

  @Test
  public void testUpdate() throws NotFoundException {
    int userId = 2;
    int vehicleId = 3;
    VehicleModel VehicleModel = service.get(userId, vehicleId);
    VehicleModel.setModel("Gun");

    service.update(userId, VehicleModel, vehicleId);

    VehicleModel dbVehicle = service.get(userId, vehicleId);
    assertNotNull(dbVehicle);
    assertEquals("Gun", dbVehicle.getModel());
    assertEquals(2, dbVehicle.getCapacity());

  }

  @Test(expected = NotFoundException.class)
  public void testUpdateNotFound() throws NotFoundException {
    VehicleModel VehicleModel = service.get(1, 10);
    VehicleModel.setModel("Hyundai");

    service.update(1, VehicleModel, 10);
    assertNull(VehicleModel);
  }

  // delete

  @Test(expected = NotFoundException.class)
  public void testDelete() throws NotFoundException {
    service.delete(1,1);
    VehicleModel Vehicle = service.get(1,1);
    assertNull(Vehicle);
  }

}

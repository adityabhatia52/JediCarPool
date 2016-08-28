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

import com.practo.carpool.data.model.UserModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.run.Application;
import com.practo.carpool.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

  @Autowired
  private UserService service;

  @Test
  public void testGet() throws NotFoundException {
    // Get All
    ArrayList<UserModel> users = (ArrayList<UserModel>) service.get();
    assertEquals(3, users.size());
    assertEquals("Aditya", users.get(0).getName());
    assertEquals("Ankit", users.get(1).getName());

    // Get One
    UserModel user = service.get(2);
    assertNotNull(user);
    assertEquals("Ankit", user.getName());
    assertEquals("ankit@practo.com", user.getEmail());
    assertEquals("1234567891", user.getMobile());
  }

  @Test(expected = NotFoundException.class)
  public void testGetNotFound() throws NotFoundException {
    UserModel userModel = service.get(10);
    assertNull(userModel);
  }

  // Create
  @Test
  public void testCreate() throws NotFoundException {
    UserModel user = new UserModel();
    user.setName("Poorna");
    user.setEmail("poorna@practo.com");
    user.setMobile("9912381797");
    user = service.create(user);
    UserModel dbUser = service.get(4);
    assertNotNull(dbUser);
    assertEquals("Poorna", dbUser.getName());
    assertEquals("poorna@practo.com", dbUser.getEmail());
    assertEquals("9912381797", dbUser.getMobile());
  }

  // update
  @Test
  public void testUpdate() throws NotFoundException {
    UserModel userModel = service.get(2);
    userModel.setName("Chetan");
    userModel.setEmail("chetan@practo.com");

    service.update(userModel, 2);

    UserModel dbUser = service.get(2);
    assertNotNull(dbUser);
    assertEquals("Chetan", dbUser.getName());
    assertEquals("chetan@practo.com", dbUser.getEmail());
  }

  // updating a record which doesn't exist
  @Test(expected = NotFoundException.class)
  public void testUpdateNotFound() throws NotFoundException {
    UserModel userModel = service.get(10);
    userModel.setName("Chetan");
    userModel.setEmail("chetan@practo.com");

    service.update(userModel, 10);
    assertNull(userModel);
  }

  // delete
  @Test(expected = NotFoundException.class)
  public void testDelete() throws NotFoundException {
    service.delete(3);
    UserModel user = service.get(3);
    assertNull(user);
  }

}

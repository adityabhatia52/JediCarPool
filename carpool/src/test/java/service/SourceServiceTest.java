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

import com.practo.carpool.data.model.SourceModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.run.Application;
import com.practo.carpool.service.SourceService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SourceServiceTest {

  @Autowired
  private SourceService service;

  @Test
  public void testAGet() throws NotFoundException {
    // Get All Sources of user with id 1
    ArrayList<SourceModel> sources = (ArrayList<SourceModel>) service.get();
    assertEquals(3, sources.size());
    assertEquals("Kalyani Magnum Tech Park", sources.get(0).getAddress());
    assertEquals("Practo Mars", sources.get(0).getNameOffice());

    // Get One
    SourceModel sourceModel = service.get(2);
    assertEquals("Gopalan Mall", sourceModel.getAddress());
    assertEquals("Practo Venus", sourceModel.getNameOffice());
  }


  @Test(expected = NotFoundException.class)
  public void testBGetNotFound() throws NotFoundException {
    SourceModel sourceModel = service.get(11);
    assertNull(sourceModel);
  }

  // Create

  @Test
  public void testCreate() throws NotFoundException {
    SourceModel sourceModel = new SourceModel();
    sourceModel.setAddress("680, Outer Ring Rd");
    sourceModel.setNameOffice("Practo Operations");
    sourceModel = service.create(sourceModel);
    SourceModel dbSource = service.get(4);
    assertNotNull(dbSource);
    assertEquals("680, Outer Ring Rd", dbSource.getAddress());
    assertEquals("Practo Operations", dbSource.getNameOffice());
  }


  // update

  @Test
  public void testDUpdate() throws NotFoundException {
    SourceModel sourceModel = service.get(4);
    sourceModel.setNameOffice("Practo Ops");

    service.update(sourceModel, 4);

    SourceModel dbSource = service.get(4);
    assertNotNull(dbSource);
    assertEquals("Practo Ops", dbSource.getNameOffice());
  }

  @Test(expected = NotFoundException.class)
  public void testEUpdateNotFound() throws NotFoundException {
    SourceModel sourceModel = service.get(10);
    sourceModel.setNameOffice("Hyundai");
    service.update(sourceModel, 10);
    assertNull(sourceModel);
  }

  // delete
  @Test(expected = NotFoundException.class)
  public void testFDelete() throws NotFoundException {
    service.delete(4);
    SourceModel source = service.get(4);
    assertNull(source);
  }
}

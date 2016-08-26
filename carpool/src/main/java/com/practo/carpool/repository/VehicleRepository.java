/**
 * 
 */
package com.practo.carpool.repository;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Vehicle;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
@Repository
public class VehicleRepository implements CrudRepository<Vehicle, Integer> {

  @Autowired
  protected HibernateTemplate hibTemp;

  @Override
  public Iterable<Vehicle> findAll() {
    return hibTemp.loadAll(Vehicle.class);
  }

  @Override
  public Vehicle findOne(Integer id) throws NotFoundException {
    try {
      return hibTemp.load(Vehicle.class, id);
    } catch (DataAccessException e) {
      throw new NotFoundException("No Vehicle found for the given Id");
    }
  }

  @Override
  @Transactional
  public Vehicle save(Vehicle entity) throws NotFoundException {
    // try-catch will be triggered on attempting to update an entity which doesn't exist
      hibTemp.merge(entity);
      return entity;
  }

  @Override
  @Transactional
  public void delete(Integer id) throws NotFoundException {
    hibTemp.delete(findOne(id));

  }

  public Vehicle findByUserIdAndId(int userId, int vehicleId) throws NotFoundException {
    try {
      return (Vehicle) hibTemp
          .findByCriteria(DetachedCriteria.forClass(Vehicle.class)
              .add(Restrictions.eq("user.id", userId)).add(Restrictions.eq("id", vehicleId)))
          .get(0);
    } catch (IndexOutOfBoundsException e) {
      throw new NotFoundException("No Vehicle found for the given User");
    }
  }

  public List<Vehicle> findByUserId(int userId) {
    return (List<Vehicle>) hibTemp.findByCriteria(
        DetachedCriteria.forClass(Vehicle.class).add(Restrictions.eq("user.id", userId)));
  }
}

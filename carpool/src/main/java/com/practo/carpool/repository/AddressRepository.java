/**
 * 
 */
package com.practo.carpool.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Address;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
@Repository
public class AddressRepository implements CrudRepository<Address, Integer> {

  @Autowired
  protected HibernateTemplate hibTemp;

  @Override
  public Iterable<Address> findAll() {
    return hibTemp.loadAll(Address.class);
  }

  @Override
  public Address findOne(Integer id) throws NotFoundException {
    try {
      return hibTemp.load(Address.class, id);
    } catch (DataAccessException e) {
      throw new NotFoundException("No Address found for the given Id");
    }
  }

  @Override
  @Transactional
  public Address save(Address entity) throws NotFoundException {
    // try-catch will be triggered on attempting to update an entity which doesn't exist
    try {
      hibTemp.merge(entity);
      return entity;
    } catch (DataAccessException e) {
      throw new NotFoundException("No Address found for the given Id");
    }
  }

  @Override
  @Transactional
  public void delete(Integer id) throws NotFoundException {
    hibTemp.delete(findOne(id));
  }

}

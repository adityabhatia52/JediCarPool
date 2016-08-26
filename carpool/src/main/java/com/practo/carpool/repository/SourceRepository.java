/**
 * 
 */
package com.practo.carpool.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Source;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
@Repository
public class SourceRepository implements CrudRepository<Source, Integer> {

  @Autowired
  protected HibernateTemplate hibTemp;

  @Override
  public Iterable<Source> findAll() {
    return hibTemp.loadAll(Source.class);
  }

  @Override
  public Source findOne(Integer id) throws NotFoundException {
    try {
      return hibTemp.load(Source.class, id);
    } catch (DataAccessException e) {
      throw new NotFoundException("No Source found for the given Id");
    }
  }

  @Override
  @Transactional
  public Source save(Source entity) throws NotFoundException {
    // try-catch will be triggered on attempting to update an entity which doesn't exist
    try {
      hibTemp.merge(entity);
      return entity;
    } catch (DataAccessException e) {
      throw new NotFoundException("No Source found for the given Id");
    }
  }

  @Override
  @Transactional
  public void delete(Integer id) throws NotFoundException {
    hibTemp.delete(findOne(id));

  }
}

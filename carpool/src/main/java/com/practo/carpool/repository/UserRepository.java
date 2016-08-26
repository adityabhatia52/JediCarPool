package com.practo.carpool.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.User;
import com.practo.carpool.exceptions.NotFoundException;

@Repository
public class UserRepository implements CrudRepository<User, Integer> {

  @Autowired
  protected HibernateTemplate hibTemp;

  @Override
  public Iterable<User> findAll() {
    return hibTemp.loadAll(User.class);
  }

  @Override
  public User findOne(Integer id) throws NotFoundException {
    try {
      return hibTemp.load(User.class, id);
    } catch (DataAccessException e) {
      throw new NotFoundException("No User found for the given Id");
    }
  }

  @Override
  @Transactional
  public User save(User entity) throws NotFoundException {
    // try-catch will be triggered on attempting to update an entity which doesn't exist
    try {
      hibTemp.merge(entity);
      return entity;
    } catch (DataAccessException e) {
      throw new NotFoundException("No User found for the given Id");
    }
  }
  

  @Override
  @Transactional
  public void delete(Integer id) throws NotFoundException {
    hibTemp.delete(findOne(id));

  }

}

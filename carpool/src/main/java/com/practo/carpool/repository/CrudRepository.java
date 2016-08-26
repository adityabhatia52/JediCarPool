package com.practo.carpool.repository;

import com.practo.carpool.exceptions.NotFoundException;

public interface CrudRepository<Entity, Id> {

  public Iterable<Entity> findAll();

  public Entity findOne(Id id) throws NotFoundException;

  public Entity save(Entity entity) throws NotFoundException;

  public void delete(Id id) throws NotFoundException;
}

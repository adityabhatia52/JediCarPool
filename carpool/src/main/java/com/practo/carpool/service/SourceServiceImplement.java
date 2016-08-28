/**
 * 
 */

package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Source;
import com.practo.carpool.data.model.SourceModel;
import com.practo.carpool.exceptions.NotFoundException;
import com.practo.carpool.repository.SourceRepository;

/**
 * @author aditya
 *
 */
@Service
@Transactional
public class SourceServiceImplement implements SourceService {
  @Autowired
  private SourceRepository sourceRepo;

  @Override
  public Iterable<SourceModel> get() {
    Iterable<Source> entities = sourceRepo.findAll();
    List<SourceModel> ulist = new ArrayList<SourceModel>();
    for (Source entity : entities) {
      SourceModel sourceModel = new SourceModel();
      try {
        sourceModel.entityPost(entity);
        ulist.add(sourceModel);
      } catch (NotFoundException exception) {
        // Nothing needs to be done on accessing an deleted entity because the deleted entity won't
        // be added to the list
      }
    }
    return ulist;
  }

  @Override
  public SourceModel get(int id) throws NotFoundException {
    Source sourceEntity = sourceRepo.findOne(id);
    SourceModel um = new SourceModel();
    try {
      um.entityPost(sourceEntity);
    } catch (ObjectNotFoundException exception) {
      throw new NotFoundException("Source with given id not found");
    }
    return um;
  }

  @Override
  public SourceModel create(SourceModel sourceModel) {
    Source entity = new Source();
    entity = sourceModel.entityGet();
    entity.setCreatedAt(new Date());
    try {
      sourceRepo.save(entity);
      sourceModel.entityPost(entity);
    } catch (NotFoundException exception) {
      exception.printStackTrace();
    }
    return sourceModel;
  }

  @Override
  public SourceModel update(SourceModel sourceModel, int id) throws NotFoundException {
    if (sourceRepo.findOne(id).getDeletedAt() == null) {
      Source entity = new Source();
      entity = sourceModel.entityGet();
      entity.setId(id);
      entity.setModifiedAt(new Date());
      try {
        sourceRepo.save(entity);
        sourceModel.entityPost(entity);
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }
      return sourceModel;
    } else {
      throw new NotFoundException("Source with the given id doesn't exist");
    }
  }

  @Override
  public void delete(int id) throws NotFoundException {
    try {
      Source sourceEntity = sourceRepo.findOne(id);
      sourceEntity.setDeletedAt(new Date());
    } catch (ObjectNotFoundException exception) {
      throw new NotFoundException("Source with the given id doesn't exist");
    }
  }

}

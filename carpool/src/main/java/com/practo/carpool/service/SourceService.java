package com.practo.carpool.service;

import com.practo.carpool.data.model.SourceModel;
import com.practo.carpool.exceptions.NotFoundException;

public interface SourceService {
  
  public Iterable<SourceModel> get();
  
  public SourceModel get(int id) throws NotFoundException;

  public SourceModel create(SourceModel sourceModel);

  public SourceModel update(SourceModel sourceModel,int id) throws NotFoundException;
  
  public void delete(int id) throws NotFoundException;
}

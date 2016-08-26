package com.practo.carpool.service;

import com.practo.carpool.data.model.VehicleModel;
import com.practo.carpool.exceptions.NotFoundException;

public interface VehicleService {

  public Iterable<VehicleModel> get(int UserId);

  public VehicleModel get(int UserId, int id) throws NotFoundException;

  public VehicleModel create(int UserId, VehicleModel VehicleModel);

  public VehicleModel update(int UserId,VehicleModel VehicleModel, int id) throws NotFoundException ;

  public void delete(int UserId,int id) throws NotFoundException;
}

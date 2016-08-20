package com.practo.carpool.service;

import com.practo.carpool.data.model.VehicleModel;

public interface VehicleService {

  public Iterable<VehicleModel> get();

  public VehicleModel get(int id);

  public VehicleModel create(VehicleModel VehicleModel);

  public VehicleModel update(VehicleModel VehicleModel, int id);

  public void delete(int id);
}

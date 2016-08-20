/**
 * 
 */
package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Listing;
import com.practo.carpool.data.model.ListingModel;
import com.practo.carpool.repository.ListingRepository;

/**
 * @author aditya
 *
 */
@Service
@Transactional
public class ListingServiceImplement implements ListingService {
  @Autowired
  private ListingRepository listingRepo;

  @Override
  public Iterable<ListingModel> get() {
    // TODO Auto-generated method stub
    Iterable<Listing> entities = listingRepo.findAll();
    List<ListingModel> ulist = new ArrayList<ListingModel>();
    for (Listing entity : entities) {
      ListingModel u = new ListingModel();
      u.entityPost(entity);
      ulist.add(u);
    }
    return ulist;

  }

  @Override
  public ListingModel get(int id) {
    // TODO Auto-generated method stub
    Listing entity = listingRepo.findOne(id);
    ListingModel listingModel = new ListingModel();
    listingModel.entityPost(entity);
    return listingModel;
  }

  @Override
  public ListingModel create(ListingModel listingModel) {
    // TODO Auto-generated method stub
    Listing entity = new Listing();
    entity = listingModel.entityGet();
    listingRepo.save(entity);
    return listingModel;
  }

  @Override
  public ListingModel update(ListingModel listingModel, int id) {
    // TODO Auto-generated method stub
    Listing entity = new Listing();
    entity = listingModel.entityGet();
    entity.setId(id);
    listingRepo.save(entity);
    listingModel.entityPost(entity);
    return listingModel;
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    listingRepo.delete(id);
  }


}

package com.practo.carpool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Listing;
import com.practo.carpool.data.filter.ListingFilter;
import com.practo.carpool.data.model.ListingModel;
import com.practo.carpool.exceptions.NotFoundException;
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

  public Iterable<ListingModel> search(ListingFilter filterObj, Pageable pageable)
      throws NotFoundException {
    Iterable<Listing> entities = listingRepo.filter(filterObj, pageable);
    ArrayList<ListingModel> listings = new ArrayList<ListingModel>();
    for (Listing entity : entities) {
      ListingModel listingModel = new ListingModel();
      listingModel.entityPost(entity);
      listings.add(listingModel);
    }
    return listings;
  }

  @Override
  public Iterable<ListingModel> get(Pageable pageable) {
    Iterable<Listing> entities = listingRepo.findAll(pageable);
    List<ListingModel> ulist = new ArrayList<ListingModel>();
    for (Listing listingEntity : entities) {
      ListingModel u = new ListingModel();
      try {
        u.entityPost(listingEntity);
        ulist.add(u);
      } catch (NotFoundException exception) {
        // Nothing needs to be done on accessing an deleted entity because the deleted entity won't
        // be added to the list
      }
    }
    return ulist;

  }

  @Override
  public ListingModel get(int id) throws NotFoundException {
    Listing listingEntity = listingRepo.findOne(id);
    ListingModel listingModel = new ListingModel();
    try {
      listingModel.entityPost(listingEntity);
    } catch (ObjectNotFoundException exception) {
      throw new NotFoundException("Source with given id not found");
    }
    return listingModel;
  }

  @Override
  public ListingModel create(ListingModel listingModel) {
    Listing listingEntity = new Listing();
    listingEntity = listingModel.entityGet();
    listingEntity.setCreatedAt(new Date());
    listingEntity.setAvailability((byte) 1);
    try {
      listingEntity = listingRepo.save(listingEntity);
      listingModel.entityPost(listingEntity);
    } catch (NotFoundException exception) {
      exception.printStackTrace();
    }
    return listingModel;
  }

  @Override
  public ListingModel update(ListingModel listingModel, int id) throws NotFoundException {
    if (listingRepo.findOne(id).getDeletedAt() == null) {
      Listing listingEntity = new Listing();
      listingEntity = listingModel.entityGet();
      listingEntity.setId(id);
      listingEntity.setModifiedAt(new Date());
      try {
        listingRepo.save(listingEntity);
        listingModel.entityPost(listingEntity);
      } catch (NotFoundException exception) {
        exception.printStackTrace();
      }
      return listingModel;
    } else {
      throw new NotFoundException("Listing with the given id doesn't exist");
    }
  }

  @Override
  public void delete(int id) throws NotFoundException {
    try {
      Listing listingEntity = listingRepo.findOne(id);
      listingEntity.setDeletedAt(new Date());
    } catch (ObjectNotFoundException exception) {
      throw new NotFoundException("Listing with the given id doesn't exist");
    }
  }


}

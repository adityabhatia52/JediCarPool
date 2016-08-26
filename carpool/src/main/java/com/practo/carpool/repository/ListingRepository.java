package com.practo.carpool.repository;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Listing;
import com.practo.carpool.data.filter.ListingFilter;
import com.practo.carpool.exceptions.NotFoundException;

@Repository
public class ListingRepository implements CrudRepository<Listing, Integer> {

  @Autowired
  protected HibernateTemplate hibTemp;

  @Override
  public Iterable<Listing> findAll() {
    return hibTemp.loadAll(Listing.class);
  }


  public Iterable<Listing> findAll(Pageable pageable) {
    return hibTemp.loadAll(Listing.class);
  }

  @Override
  public Listing findOne(Integer id) throws NotFoundException {
    try {
      return hibTemp.load(Listing.class, id);
    } catch (DataAccessException e) {
      throw new NotFoundException("No Listing found for the given Id");
    }
  }

  @Override
  @Transactional
  public Listing save(Listing entity) throws NotFoundException {
    // try-catch will be triggered on attempting to update an entity which doesn't exist
    try {
      hibTemp.merge(entity);
      return entity;
    } catch (DataAccessException e) {
      throw new NotFoundException("No Listing found for the given Id");
    }
  }

  @Override
  @Transactional
  public void delete(Integer id) throws NotFoundException {
    hibTemp.delete(findOne(id));

  }

  public Iterable<Listing> filter(ListingFilter filter, Pageable pageable) {

    DetachedCriteria criteria = DetachedCriteria.forClass(Listing.class);

    criteria = criteria.add(Restrictions.between("seatAvailable", filter.getMinSeatsAvailable(),
        filter.getMaxSeatsAvailable()));

    criteria = criteria
        .add(Restrictions.between("seatAvailable", filter.getMinTime(), filter.getMaxTime()));

    if ((Integer) filter.getSource() != null) {
      criteria = criteria.add(Restrictions.eq("source.id", filter.getSource()));
    }

    return (Iterable<Listing>) hibTemp.findByCriteria(criteria, pageable.getOffset(),
        pageable.getPageSize());
  }

}

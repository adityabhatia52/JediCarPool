/**
 * 
 */
package com.practo.carpool.repository;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practo.carpool.data.entity.Booking;
import com.practo.carpool.exceptions.NotFoundException;

/**
 * @author aditya
 *
 */
@Repository
public class BookingRepository implements CrudRepository<Booking, Integer> {

  @Autowired
  protected HibernateTemplate hibTemp;

  @Override
  public Iterable<Booking> findAll() {
    return hibTemp.loadAll(Booking.class);
  }

  @Override
  public Booking findOne(Integer id) throws NotFoundException {
    try {
      return hibTemp.load(Booking.class, id);
    } catch (DataAccessException exception) {
      throw new NotFoundException("No Booking found for the given Id");
    }
  }

  @Override
  @Transactional
  public Booking save(Booking entity) throws NotFoundException {
    // try-catch will be triggered on attempting to update an entity which doesn't exist
    try {
      hibTemp.merge(entity);
      return entity;
    } catch (DataAccessException exception) {
      throw new NotFoundException("No Booking found for the given Id");
    }
  }

  @Override
  @Transactional
  public void delete(Integer id) throws NotFoundException {
    hibTemp.delete(findOne(id));
  }

  public Iterable<Booking> findByListingId(Integer listingId) {
    return (Iterable<Booking>) hibTemp.findByCriteria(
        DetachedCriteria.forClass(Booking.class).add(Restrictions.eq("listing.id", listingId)));
  }

  public Booking findByListingIdAndId(Integer listingId, Integer bookingId)
      throws NotFoundException {
    try {
      return (Booking) hibTemp.findByCriteria(DetachedCriteria.forClass(Booking.class)
          .add(Restrictions.eq("listing.id", listingId)).add(Restrictions.eq("id", bookingId))).get(0);
    } catch (IndexOutOfBoundsException exception) {
      throw new NotFoundException("No Booking found with given Id");
    }
  }

}

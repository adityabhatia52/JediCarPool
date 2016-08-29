package com.practo.carpool.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the listing database table.
 * 
 */
@Entity
@NamedQuery(name = "Listing.findAll", query = "SELECT l FROM Listing l")
public class Listing implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private byte availability;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, updatable = false)
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "deleted_at")
  private Date deletedAt;

  @Column(name = "depart_time")
  private Timestamp departTime;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modified_at")
  private Date modifiedAt;

  @Column(name = "seat_available")
  private int seatAvailable;

  // bi-directional many-to-one association to Booking
  @OneToMany(mappedBy = "listing")
  private List<Booking> bookings;

  // bi-directional many-to-one association to Vehicle
  @ManyToOne
  @JoinColumn(name = "id_vehicle")
  private Vehicle vehicle;

  // bi-directional many-to-one association to Address
  @ManyToOne
  @JoinColumn(name = "id_destination")
  private Address address;

  // bi-directional many-to-one association to User
  @ManyToOne
  @JoinColumn(name = "id_lister")
  private User user;

  // bi-directional many-to-one association to Source
  @ManyToOne
  @JoinColumn(name = "id_source")
  private Source source;

  public Listing() {}

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public byte getAvailability() {
    return this.availability;
  }

  public void setAvailability(byte availability) {
    this.availability = availability;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getDeletedAt() {
    return this.deletedAt;
  }

  public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
  }

  public Timestamp getDepartTime() {
    return this.departTime;
  }

  public void setDepartTime(Timestamp departTime) {
    this.departTime = departTime;
  }

  public Date getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public int getSeatAvailable() {
    return this.seatAvailable;
  }

  public void setSeatAvailable(int seatAvailable) {
    this.seatAvailable = seatAvailable;
  }

  public List<Booking> getBookings() {
    return this.bookings;
  }

  public void setBookings(List<Booking> bookings) {
    this.bookings = bookings;
  }

  public Booking addBooking(Booking booking) {
    getBookings().add(booking);
    booking.setListing(this);

    return booking;
  }

  public Booking removeBooking(Booking booking) {
    getBookings().remove(booking);
    booking.setListing(null);

    return booking;
  }

  public Vehicle getVehicle() {
    return this.vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Source getSource() {
    return this.source;
  }

  public void setSource(Source source) {
    this.source = source;
  }

}

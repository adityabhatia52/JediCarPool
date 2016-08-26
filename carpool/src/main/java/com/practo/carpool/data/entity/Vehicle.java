package com.practo.carpool.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int capacity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at",nullable = false, updatable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deleted_at")
	private Date deletedAt;

	private String model;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_at")
	private Date modifiedAt;

	@Column(name="number_plate")
	private String numberPlate;

	//bi-directional many-to-one association to Listing
	@OneToMany(mappedBy="vehicle")
	private List<Listing> listings;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_owner")
	private User user;

	public Vehicle() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
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

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getModifiedAt() {
		return this.modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getNumberPlate() {
		return this.numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public List<Listing> getListings() {
		return this.listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}

	public Listing addListing(Listing listing) {
		getListings().add(listing);
		listing.setVehicle(this);

		return listing;
	}

	public Listing removeListing(Listing listing) {
		getListings().remove(listing);
		listing.setVehicle(null);

		return listing;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
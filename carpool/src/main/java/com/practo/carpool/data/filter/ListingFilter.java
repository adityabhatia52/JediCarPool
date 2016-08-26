package com.practo.carpool.data.filter;

import java.util.Date;

import com.practo.carpool.data.model.AddressModel;

public class ListingFilter {
  int source;
  int seatsAvailable;
  AddressModel destination;
  Date departTime;

  int minSeatsAvailable;
  int maxSeatsAvailable;

  int minTime;
  int maxTime;

  public int getSource() {
    return source;
  }

  public void setSource(int source) {
    this.source = source;
  }

  public Integer getSeatsAvailable() {
    return seatsAvailable;
  }

  public void setSeatsAvailable(int seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
  }

  public AddressModel getDestination() {
    return destination;
  }

  public void setDestination(AddressModel destination) {
    this.destination = destination;
  }

  public Date getDepartureTime() {
    return departTime;
  }

  public void setDepartureTime(Date departTime) {
    this.departTime = departTime;
  }

  public int getMaxSeatsAvailable() {
    return maxSeatsAvailable;
  }

  public void setMaxSeatsAvailable(int maxSeatsAvailable) {
    this.maxSeatsAvailable = maxSeatsAvailable;
  }

  public int getMinSeatsAvailable() {
    return minSeatsAvailable;
  }

  public void setMinSeatsAvailable(int minSeatsAvailable) {
    this.minSeatsAvailable = minSeatsAvailable;
  }
  
  public int getMinTime(){
    return minTime;
  }
  
  public void setMinTime(int minTime){
    this.minTime = minTime;
  }
  
  public int getMaxTime(){
    return maxTime;
  }
  
  public void setMaxTime(int maxTime){
    this.maxTime = maxTime;
  }
  
}

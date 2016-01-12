package com.thoughtworks.videoclub;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Settlement {

  private final ImmutableList<Rental> rentals;

  public Settlement(List<Rental> rentals) {
    this.rentals = ImmutableList.copyOf(rentals);
  }

  public double totalAmount() {
    return rentals.stream().mapToDouble(Rental::priceCharge).sum();
  }

  public int bonus() {
    return rentals.stream().mapToInt(Rental::bonus).sum();
  }

  public List<Rental> rentals() {
    return rentals;
  }

}

package com.thoughtworks.videoclub;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private final String name;
  private final List<Rental> rentals;

  public Customer(String name) {
    this.name = name;
    rentals = new ArrayList<>();
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    String result = "Rental Record for " + getName() + "\n";
    for(Rental rent : rentals) {
      result += "\t" + rent.getMovie().title() + "\t"
          + String.valueOf(rent.priceCharge()) + "\n";
    }
    result += "Amount owed is " + String.valueOf(totalAmount()) + "\n";
    result += "You earned " + String.valueOf(bonus())
        + " frequent renter points";
    return result;
  }

  private double totalAmount() {
    return rentals.stream().mapToDouble(Rental::priceCharge).sum();
  }

  private int bonus() {
    return rentals.stream().mapToInt(Rental::bonus).sum();
  }

}

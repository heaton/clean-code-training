package com.thoughtworks.videoclub;

public class StatementTemplate {

  public String statement(String customerName, Settlement settlement) {
    StringBuffer result = new StringBuffer("Rental Record for " + customerName + "\n");
    for (Rental rent : settlement.rentals()) {
      result.append("\t").append(rent.getMovie().title()).append("\t")
          .append(rent.priceCharge()).append("\n");
    }
    result.append("Amount owed is ").append(settlement.totalAmount()).append("\n")
        .append("You earned ").append(settlement.bonus())
        .append(" frequent renter points");
    return result.toString();
  }

}

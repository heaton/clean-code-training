package com.thoughtworks.videoclub;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private final String name;
  private final List<Rental> rentals;
  private final StatementTemplate statementTemplate;
  private final Account account;

  public Customer(String name) {
    this.name = name;
    rentals = new ArrayList<>();
    this.statementTemplate = new StatementTemplate();
    this.account = new Account();
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String statement() {
    final Settlement settlement = account.settle(rentals);
    return statementTemplate.statement(name, settlement);
  }

}

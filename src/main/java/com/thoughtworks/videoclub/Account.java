package com.thoughtworks.videoclub;

import java.util.List;

public class Account {

  public Settlement settle(List<Rental> rentals) {
    return new Settlement(rentals);
  }

}

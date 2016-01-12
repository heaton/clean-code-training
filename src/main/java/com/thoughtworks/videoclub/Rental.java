package com.thoughtworks.videoclub;

public class Rental {
  private final Movie movie;
  private final int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double priceCharge() {
    return movie.price().charge(daysRented);
  }

  public int bonus() {
    return thereIsBonus() ? 2 : 1;
  }

  private boolean thereIsBonus() {
    return (getMovie().price() == Price.NEW_RELEASE) && daysRented > 1;
  }

}

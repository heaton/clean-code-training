package com.thoughtworks.videoclub;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class RentalTest {

  private Rental rental;

  @Test
  public void given_a_regular_movie_when_the_rental_days_are_less_than_3_then_the_price_should_be_2 () {
    rental = new Rental(new Movie("name", Price.REGULAR), 1);
    assertThat(rental.priceCharge(), is(2.0));
  }

  @Test
  public void given_a_regular_movie_when_the_rental_days_are_more_than_2_then_it_should_charge_additional_1half_per_extra_day () {
    rental = new Rental(new Movie("name", Price.REGULAR), 3);
    assertThat(rental.priceCharge(), is(3.5));
  }

  @Test
  public void when_it_is_a_new_movie_then_it_should_charge_3_per_day () {
    rental = new Rental(new Movie("name", Price.NEW_RELEASE), 2);
    assertThat(rental.priceCharge(), is(6.0));
  }

  @Test
  public void given_a_children_movie_when_the_rental_days_are_less_than_4_then_the_price_should_be_1half () {
    rental = new Rental(new Movie("name", Price.CHILDREN), 3);
    assertThat(rental.priceCharge(), is(1.5));
  }

  @Test
  public void given_a_children_movie_when_the_rental_days_are_more_than_3_then_it_should_charge_additional_1half_per_extra_day () {
    rental = new Rental(new Movie("name", Price.CHILDREN), 6);
    assertThat(rental.priceCharge(), is(6.0));
  }

}

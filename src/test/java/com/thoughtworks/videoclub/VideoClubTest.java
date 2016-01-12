package com.thoughtworks.videoclub;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class VideoClubTest {

  protected Movie m0, m11, m12, m2;
  protected Customer customer;

  @Before
  public void given_4_movies() {
    m11 = new Movie("Sky Captain", Price.NEW_RELEASE);
    m12 = new Movie("Alejandro Magno", Price.NEW_RELEASE);
    m0 = new Movie("Accion Mutante", Price.REGULAR);
    m2 = new Movie("Hermano Oso", Price.CHILDREN);

    customer = new Customer("Manuel");
  }

  @Test
  public void the_statement_should_give_all_the_price_of_each_movie_rental_and_the_total_price_and_the_bonus() {

    Rental r1 = new Rental(m11, 5);
    Rental r2 = new Rental(m0, 1);
    Rental r3 = new Rental(m2, 10);

    customer.addRental(r1);
    customer.addRental(r2);
    customer.addRental(r3);

    String statement = customer.statement();

    String expectedStatement = "Rental Record for Manuel\n"
        + "\tSky Captain\t15.0\n" + "\tAccion Mutante\t2.0\n"
        + "\tHermano Oso\t12.0\n" + "Amount owed is 29.0\n"
        + "You earned 4 frequent renter points";

    assertThat(statement, equalTo(expectedStatement));
  }

}
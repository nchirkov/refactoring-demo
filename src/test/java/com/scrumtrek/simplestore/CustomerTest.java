package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CustomerTest {
    @Test
    public void shouldSetupNameWhenCreateCustomer() {
        Customer sut = new Customer("newCustomer");
        Assert.assertEquals("newCustomer", sut.getName());
    }

    @Test
    public void shouldCost2Dollars_WhenAddRegularMovieFor1Day() {
        Customer sut = new Customer("newCustomer");

        Movie movie = new Movie("Star Wars", PriceCodes.Regular);
        Rental rental = new Rental(movie, 1);

        sut.addRental(rental);

        Assert.assertTrue(sut.Statement().contains("2.0"));
    }

    @Test
    public void shouldCost6point5Dollars_WhenAddRegularMovieFor5Day() {
        Customer sut = new Customer("newCustomer");
        Movie movie = new Movie("Star Wars", PriceCodes.Regular);
        Rental rental = new Rental(movie, 5);

        sut.addRental(rental);

        Assert.assertTrue(sut.Statement().contains("6.5"));
    }

    @Test
    public void shouldCost4Dollars_WhenAdd2RegularMovieFor1Day() {
        Customer sut = new Customer("newCustomer");
        Movie movie1 = new Movie("Star Wars", PriceCodes.Regular);
        Movie movie2 = new Movie("Star Wars II", PriceCodes.Regular);
        Rental rental1 = new Rental(movie1, 1);
        Rental rental2 = new Rental(movie2, 1);

        sut.addRental(rental1);
        sut.addRental(rental2);

        Assert.assertTrue(sut.Statement().contains("4.0"));
    }
}

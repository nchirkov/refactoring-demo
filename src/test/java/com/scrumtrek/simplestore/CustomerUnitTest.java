package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerUnitTest {
    @Test
    public void shouldSetupName_WhenCreateCustomer() {
        Customer sut = new Customer("newCustomer");
        assertEquals("newCustomer", sut.getName());
    }

    @Test
    public void shouldCost2Dollars_WhenAddRegularMovieFor1Day() {
        Customer sut = new Customer("newCustomer");

        Movie stubMovie = mock(Movie.class);
        when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);

        Rental stubRental = mock(Rental.class);
        when(stubRental.getDaysRented()).thenReturn(1);
        when(stubRental.getMovie()).thenReturn(stubMovie);

        sut.addRental(stubRental);

        assertTrue(sut.Statement().contains("2.0"));
    }

    @Test
    public void shouldCost6point5Dollars_WhenAddRegularMovieFor5Day() {
        Customer sut = new Customer("newCustomer");

        Movie stubMovie = mock(Movie.class);
        when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);

        Rental stubRental = mock(Rental.class);
        when(stubRental.getDaysRented()).thenReturn(5);
        when(stubRental.getMovie()).thenReturn(stubMovie);

        sut.addRental(stubRental);

        assertTrue(sut.Statement().contains("6.5"));
    }

     @Test
     public void shouldCost4Dollars_WhenAdd2RegularMovieFor1Day() {
        Customer sut = new Customer("newCustomer");

        Movie stubMovie = mock(Movie.class);
        when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);

        Rental stubRental1 = mock(Rental.class);
        when(stubRental1.getDaysRented()).thenReturn(1);
        when(stubRental1.getMovie()).thenReturn(stubMovie);

        Rental stubRental2 = mock(Rental.class);
        when(stubRental2.getDaysRented()).thenReturn(1);
        when(stubRental2.getMovie()).thenReturn(stubMovie);

        sut.addRental(stubRental1);
        sut.addRental(stubRental2);

        assertTrue(sut.Statement().contains("4.0"));
    }

    @Test
    public void shouldCost3Dollars_WhenAddNewReleaseMovieFor1Day() {
        Customer sut = new Customer("newCustomer");

        Movie stubMovie = mock(Movie.class);
        when(stubMovie.getPriceCode()).thenReturn(PriceCodes.NewRelease);

        Rental stubRental = mock(Rental.class);
        when(stubRental.getDaysRented()).thenReturn(1);
        when(stubRental.getMovie()).thenReturn(stubMovie);

        sut.addRental(stubRental);

        assertTrue(sut.Statement().contains("3.0"));
    }

    @Test
    public void shouldCost1point5Dollars_WhenAddChildrenMovieFor1Day() {
        Customer sut = new Customer("newCustomer");

        Movie stubMovie = mock(Movie.class);
        when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);

        Rental stubRental = mock(Rental.class);
        when(stubRental.getDaysRented()).thenReturn(1);
        when(stubRental.getMovie()).thenReturn(stubMovie);

        sut.addRental(stubRental);

        assertTrue(sut.Statement().contains("1.5"));
    }

    @Test
    public void should3Dollars_WhenAddChildrenMovieFor5Day() {
        Customer sut = new Customer("newCustomer");

        Movie stubMovie = mock(Movie.class);
        when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);

        Rental stubRental = mock(Rental.class);
        when(stubRental.getDaysRented()).thenReturn(5);
        when(stubRental.getMovie()).thenReturn(stubMovie);

        sut.addRental(stubRental);

        assertTrue(sut.Statement().contains("3.0"));
    }

    @Test
    public void shouldCost3Dollars_WhenAddNewReleaseMovieFor3Day() {
        Customer sut = new Customer("newCustomer");

        Movie stubMovie = mock(Movie.class);
        when(stubMovie.getPriceCode()).thenReturn(PriceCodes.NewRelease);

        Rental stubRental = mock(Rental.class);
        when(stubRental.getDaysRented()).thenReturn(3);
        when(stubRental.getMovie()).thenReturn(stubMovie);

        sut.addRental(stubRental);

        assertTrue(sut.Statement().contains("9.0"));
    }
}

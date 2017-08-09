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
    public void shouldCost6point5Dollars_WhenAddRegularMovieFor5Day() {
        Movie movie = new Movie("Test", PriceCodes.Regular);
        Rental sut = new Rental(movie, 5);

        assertEquals(6.5, sut.calculatePrice(), 0.1);
   }

    @Test
    public void shouldCost3Dollars_WhenAddNewReleaseMovieFor1Day() {
        Movie movie = new Movie("Test", PriceCodes.NewRelease);
        Rental sut = new Rental(movie, 1);

        assertEquals(3, sut.calculatePrice(), 0.1);
    }

    @Test
    public void shouldCost1point5Dollars_WhenAddChildrenMovieFor1Day() {
        Movie movie = new Movie("Test", PriceCodes.Childrens);
        Rental sut = new Rental(movie, 1);

        assertEquals(1.5, sut.calculatePrice(), 0.1);
    }

    @Test
    public void shouldCost3Dollars_WhenAddNewReleaseMovieFor3Day() {
        Movie movie = new Movie("Test", PriceCodes.NewRelease);
        Rental sut = new Rental(movie, 3);

        assertEquals(9, sut.calculatePrice(), 0.1);
    }

    @Test
    public void shouldCost3Dollars_WhenAddNewXXXMovieFor1Day() {
        Movie movie = new Movie("Test", PriceCodes.XXX);
        Rental sut = new Rental(movie, 1);

        assertEquals(1.9, sut.calculatePrice(), 0.1);
    }

    @Test
    public void shouldCost2Dollars_WhenAddRegularMovieFor1Day() {
        Movie movie = new Movie("Test", PriceCodes.Regular);
        Rental sut = new Rental(movie, 1);

        assertEquals(2, sut.calculatePrice(), 0.1);
    }

    @Test
    public void shouldCost2Dollars_WhenAddChildrenMovieFor4Day() {
        Movie movie = new Movie("Test", PriceCodes.Childrens);
        Rental sut = new Rental(movie, 4);

        assertEquals(3, sut.calculatePrice(), 0.1);
    }
}

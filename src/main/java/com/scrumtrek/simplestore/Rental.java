package com.scrumtrek.simplestore;

public class Rental {
	private Movie m_Movie;
	private int m_DaysRented;

	public Rental(Movie movie, int daysRented) {
		m_Movie = movie;
		m_DaysRented = daysRented;
	}

	public int getDaysRented() {
		return m_DaysRented;
	}

	public Movie getMovie() {
		return m_Movie;
	}

	public double calculatePrice()
	{
		double thisAmount = 0;

		switch(m_Movie.getPriceCode()) {
			case Regular:
				thisAmount += 2;
				if (m_DaysRented > 2)
				{
					thisAmount += (m_DaysRented - 2) * 1.5;
				}
				break;

			case NewRelease:
				thisAmount += m_DaysRented * 3;
				break;

			case Childrens:
				thisAmount += 1.5;
				if (m_DaysRented > 3)
				{
					thisAmount += (m_DaysRented - 3) * 1.5;
				}
				break;
			case XXX:
				thisAmount += 1.9;
				break;
		}

		return thisAmount;
	}
}


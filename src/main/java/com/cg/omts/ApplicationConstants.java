package com.cg.omts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.cg.model.Movie;
import com.cg.model.Seat;
import com.cg.model.Show;
import com.cg.model.BookingState.BookingStatus;

public class ApplicationConstants {
	
	public static List<Show> shows;
	public static final Integer THEATER_ID_1 =1; 
	public static final Integer THEATER_ID_2 =2; 
	
	public static final Integer SCREEN_ID_1 =1; 
	public static final Integer SCREEN_ID_2 =2; 
	public static final Integer TWO_HRS =2; 
	
	public static final String MOVIE_1 ="Jolly llb"; 
	public static final String MOVIE_2 = "1917";
	public static final String MOVIE_3 = null; 
	
	static{
		
		Movie movie11 = new Movie(THEATER_ID_1, TWO_HRS, MOVIE_1,"pillu", "Comedy", LocalDate.of(2020, Month.FEBRUARY, 29), new String[] {"hindi","english"});
		Movie movie12 = new Movie(THEATER_ID_1, TWO_HRS, MOVIE_2,"pillu", "Sci-fi", LocalDate.of(2020, Month.FEBRUARY, 29), new String[] {"hindi","english"});

		Movie movie21 = new Movie(THEATER_ID_2, TWO_HRS, MOVIE_1,"pillu", "Comedy", LocalDate.of(2020, Month.FEBRUARY, 29), new String[] {"hindi","english"});
		Movie movie22 = new Movie(THEATER_ID_2, TWO_HRS, MOVIE_2,"pillu", "Sci-fi", LocalDate.of(2020, Month.FEBRUARY, 29), new String[] {"hindi","english"});

		
		List<Seat> seat1 = new ArrayList<Seat>();
		seat1.add(new Seat(BookingStatus.AVAILABLE,11,150.00));
		seat1.add(new Seat(BookingStatus.AVAILABLE,12,250.00));
		seat1.add(new Seat(BookingStatus.AVAILABLE,13,350.00));
		
		List<Seat> seat2 = new ArrayList<Seat>();
		seat2.add(new Seat(BookingStatus.AVAILABLE,21,150.00));
		seat2.add(new Seat(BookingStatus.AVAILABLE,22,250.00));
		seat2.add(new Seat(BookingStatus.AVAILABLE,23,350.00));
		
		
		shows = new ArrayList<>();
		
		/*THEATER_ID_1 - SCREEN_ID_1**/
		
		shows.add(new Show(SCREEN_ID_1, THEATER_ID_1, movie11,  "show1", LocalDateTime.of(2020, Month.FEBRUARY, 29, 8, 30, 00), LocalDateTime.of(2020, Month.FEBRUARY, 29, 11, 00, 00), seat1));
		shows.add(new Show(SCREEN_ID_1, THEATER_ID_1, movie11,  "show2", LocalDateTime.of(2020, Month.FEBRUARY, 29, 11, 30, 00), LocalDateTime.of(2020, Month.FEBRUARY, 29, 14, 15, 00), seat2));
		
		/*THEATER_ID_1 - SCREEN_ID_2**/
		
		shows.add(new Show(SCREEN_ID_2, THEATER_ID_1, movie12, "show3", LocalDateTime.of(2020, Month.FEBRUARY, 29, 8, 30, 00), LocalDateTime.of(2020, Month.FEBRUARY, 29, 11, 00, 00), seat1));
		shows.add(new Show(SCREEN_ID_2, THEATER_ID_1, movie12, "show4", LocalDateTime.of(2020, Month.FEBRUARY, 29, 11, 30, 00), LocalDateTime.of(2020, Month.FEBRUARY, 29, 14, 15, 00), seat2));
	
	
		/*THEATER_ID_2 - SCREEN_ID_1**/
		
		shows.add(new Show(SCREEN_ID_1, THEATER_ID_2, movie11,  "show1", LocalDateTime.of(2020, Month.FEBRUARY, 29, 8, 30, 00), LocalDateTime.of(2020, Month.FEBRUARY, 29, 11, 00, 00), seat1));
		shows.add(new Show(SCREEN_ID_1, THEATER_ID_2, movie11,  "show2", LocalDateTime.of(2020, Month.FEBRUARY, 29, 11, 30, 00), LocalDateTime.of(2020, Month.FEBRUARY, 29, 14, 15, 00), seat2));
		
		/*THEATER_ID_2 - SCREEN_ID_2**/
		
		shows.add(new Show(SCREEN_ID_2, THEATER_ID_2, movie12, "show3", LocalDateTime.of(2020, Month.FEBRUARY, 29, 8, 30, 00), LocalDateTime.of(2020, Month.FEBRUARY, 29, 11, 00, 00), seat1));
		shows.add(new Show(SCREEN_ID_2, THEATER_ID_2, movie12, "show4", LocalDateTime.of(2020, Month.FEBRUARY, 29, 11, 30, 00), LocalDateTime.of(2020, Month.FEBRUARY, 29, 14, 15, 00), seat2));

	}
	

}

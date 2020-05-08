//package com.cg.omts;
//
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Set;
//
//import com.cg.model.Seat;
//import com.cg.model.Show;
//import com.cg.model.BookingState.BookingStatus;
//import com.cg.omts.service.ShowService;
//import com.cg.omts.service.impl.ShowServiceImpl;
//
///**
// * Online Ticketing System
// *
// */
//public class App {
//	
//
//	private ShowService service;
//
//	public App() {
//		service = ShowServiceImpl.getInstance();
//	}
//
//	public static void main(String[] args) {
//		App app = new App();
//		app.performTicketBooking();
//
//	}
//
//	private void performTicketBooking() {
//		showAllShows();
//		System.out.println("***********************************");
//		
//		/**search all seats for movie1 in theater 1**/
//		viewShowByMovieInTheater();
//		
//		/**search all seats for movie1 in theater 1 and time**/
//		HashMap<Show, List<Seat>> selection = getMovieShowsInTheaterAtTime();
//		Set<Show> keySet = selection.keySet();
//		
//		/***booking for first show*/
//		if(keySet != null && !keySet.isEmpty()){
//			
//			/***choose seat from first selected show with seats having price filter****/
//			doBooking(selection, keySet);
//			
//		}
//		
//	}
//	
//	private void showAllShows() {
//		List<Show> findAllShow = this.service.findAllShow();
//		for (Show show : findAllShow) {
//			System.out.println(String.format("show details are movie  %s,  show  %s, from  %s, till  %s",show.getMovieName().getMovieName(), show.getShowName(), show.getShowStartTime(), show.getShowEndTime()));
//		
//		}
//	}
//
//	private void viewShowByMovieInTheater() {
//		List<Show> findAllShowByMovieNameAndTheater1 = this.service.findAllShowByMovieNameAndTheater1(ApplicationConstants.MOVIE_1, ApplicationConstants.THEATER_ID_1);
//		for (Show show : findAllShowByMovieNameAndTheater1) {
//			System.out.println(String.format("show details are movie %s,  show  %s, from  %s, till  %s", show.getMovieName().getMovieName(), show.getShowName(), show.getShowStartTime(), show.getShowEndTime()));
//		}
//		System.out.println("****************---------------*******************");
//	}
//	
//	
//	private HashMap<Show, List<Seat>> getMovieShowsInTheaterAtTime() {
//		List<Show> showByMovieNameAndTheaterAndTime = this.service.findAllShowByMovieNameAndTheater1AndTime(ApplicationConstants.MOVIE_1, ApplicationConstants.THEATER_ID_1, LocalDateTime.of(2020, Month.FEBRUARY, 29, 10, 30, 00));
//		
//		HashMap<Show, List<Seat>> selection = new HashMap<Show, List<Seat>>();
//		
//		ShowAndSeatSelection(showByMovieNameAndTheaterAndTime, selection);
//		return selection;
//	}
//
//
//	private void ShowAndSeatSelection(List<Show> showByMovieNameAndTheaterAndTime,
//			HashMap<Show, List<Seat>> selection) {
//		for (Show show : showByMovieNameAndTheaterAndTime) {
//			System.out.println(String.format("show details are movie %s,  show  %s, from  %s, till  %s", show.getMovieName().getMovieName(), show.getShowName(), show.getShowStartTime(), show.getShowEndTime()));
//			List<Seat> seats = show.getSeats();
//			
//			List<Seat> chooseSeats =new ArrayList<>();
//			List<Seat> list = selection.get(show);
//			for (Seat seat : seats) {
//				System.out.println(seat);
//				if(seat.getSeatPrice() <350 && seat.getSeatStatus().equals(BookingStatus.AVAILABLE)){
//					chooseSeats.add(seat);
//				}
//			}
//			selection.put(show, chooseSeats);
//			System.out.println("****************----------------------------*******************");
//			
//			System.out.println(chooseSeats + "seats are selected");
//			System.out.println("****************----------------------------*******************");
//
//		}
//	}
//
//	private void doBooking(HashMap<Show, List<Seat>> selection, Set<Show> keySet) {
//		Show selectedShow = keySet.iterator().next();
//		List<Seat> chooseSeats = service.chooseSeats(selection.get(selectedShow));
//		
//		Boolean initateBooking = service.initateBooking(chooseSeats, selectedShow);
//		
//		System.out.println("----------------------------");
//		
//		System.out.println(chooseSeats + "seat initateBooking status "+initateBooking);
//		System.out.println("----------------------------");
//
//		if(initateBooking.booleanValue()){
//			FinalBookingStep(chooseSeats);
//		}
//	}
//
//	private void FinalBookingStep(List<Seat> chooseSeats) {
//		Boolean updateSeatStatus = service.updateSeatStatus(chooseSeats);
//		
//		System.out.println("****************----------------------------*******************");
//		System.out.println(" Final Booking status "+updateSeatStatus);
//		System.out.println("****************----------------------------*******************");
//	}
//
//}

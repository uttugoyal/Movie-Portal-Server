package com.cg.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Show {

	private Integer screenId;
	private Integer theaterId;
	private Long showId;
	private Movie movieName;
	private String showName;
	private LocalDateTime showStartTime;
	private LocalDateTime showEndTime;
	private List<Seat> seats;

	public Show(Integer screenId, Integer theaterId,  Movie movieName, String showName, LocalDateTime showStartTime,
			LocalDateTime showEndTime, List<Seat> seats) {

		this.screenId = screenId;
		this.theaterId = theaterId;
		this.showId = showIdGenerator();
		this.showName = showName;
		this.movieName = movieName;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.seats = seats;
	}

	public void showShowDetails(String show) {

	}

	public Long getShowId() {
		return showId;
	}

	public Integer getScreenId() {
		return screenId;
	}

	public Integer getTheaterId() {
		return theaterId;
	}

	public Movie getMovieName() {
		return movieName;
	}

	public String getShowName() {
		return showName;
	}

	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}

	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}

	public void setMovieName(Movie movie) {
		this.movieName = movie;

	}

	public Long showIdGenerator() {
		return Long.parseLong(theaterId.toString() + Optional.ofNullable(movieName).map(mo-> mo.getMovieId().toString()).orElse("") + screenId.toString());
	}

	public List<Seat> getSeats() {
		return seats;
	}

	@Override
	public String toString() {
		return "Show [movieName=" + movieName + ", showName=" + showName + ", showStartTime=" + showStartTime
				+ ", showEndTime=" + showEndTime + ", seats=" + seats + "]";
	}

}

package com.cg.model;

import com.cg.model.BookingState.BookingStatus;

public class Seat {

	private BookingStatus seatStatus;
	private Integer seatId;
	private Double seatPrice;

	public Seat(BookingStatus seatStatus, Integer seatId, Double seatPrice) {

		this.seatStatus = seatStatus;
		this.seatId = seatId;
		this.seatPrice = seatPrice;
	}

	public void blockSeat() {
		this.seatStatus = BookingStatus.BLOCKED;
	}

	public void bookSeat() {
		this.seatStatus = BookingStatus.BOOKED;
	}

	public void cancelSeat() {
		this.seatStatus = BookingStatus.AVAILABLE;
	}

	public BookingStatus getSeatStatus() {
		return seatStatus;
	}

	public Double getSeatPrice() {
		return seatPrice;
	}

	@Override
	public String toString() {
		return "Seat [seatStatus=" + seatStatus + ", seatId=" + seatId + ", seatPrice=" + seatPrice + "]";
	}
	
}

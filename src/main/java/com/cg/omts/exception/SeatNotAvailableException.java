package com.cg.omts.exception;

public class SeatNotAvailableException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public SeatNotAvailableException() {
        super();
    }

    public SeatNotAvailableException(String message) {
        super(message);
    }

    public SeatNotAvailableException(Throwable throwable) {
        super(throwable);
    }

    public SeatNotAvailableException(String message, Throwable throwable) {
        super(message, throwable); }

}

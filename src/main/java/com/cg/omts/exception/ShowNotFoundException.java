package com.cg.omts.exception;

public class ShowNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public ShowNotFoundException() {
        super();
    }

    public ShowNotFoundException(String message) {
        super(message);
    }

    public ShowNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ShowNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

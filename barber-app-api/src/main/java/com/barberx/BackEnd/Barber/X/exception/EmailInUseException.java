package com.barberx.BackEnd.Barber.X.exception;

public class EmailInUseException extends RuntimeException {

    public EmailInUseException(String message) {
        super(message);
    }

}

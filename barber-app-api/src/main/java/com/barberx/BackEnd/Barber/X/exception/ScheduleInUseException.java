package com.barberx.BackEnd.Barber.X.exception;

public class ScheduleInUseException extends RuntimeException{

    public ScheduleInUseException(String message) {
        super(message);
    }

}

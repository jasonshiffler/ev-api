package com.tesla.springboot.evapi.exceptions;

public class DataOutOfBoundsException extends RuntimeException {

    public DataOutOfBoundsException(String Message){
        super(Message);
    }
    public DataOutOfBoundsException(String message, Float high, float low, String units){
        super(message + high + " and " + low + units);
    }

}

package com.tesla.springboot.evapi.exceptions;

public class TemperatureOutOfBoundsException extends RuntimeException {

    public TemperatureOutOfBoundsException(String Message){
        super(Message);
    }
    public TemperatureOutOfBoundsException(Float high, float low){
        super("Temperature must be between " + high + " and " + low + " degrees");
    }


}

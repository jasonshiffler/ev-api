package com.tesla.springboot.evapi.exceptions;

public class DataExpectedException extends Exception {

    public DataExpectedException (){
        super("Data was expected but not provided.");
    }

    public DataExpectedException (String message){
        super(message);
    }
}

package com.tesla.springboot.evapi.exceptions;

public class DataExpectedException extends RuntimeException {

    public DataExpectedException (){
        super("Data was expected but not provided.");
    }
}

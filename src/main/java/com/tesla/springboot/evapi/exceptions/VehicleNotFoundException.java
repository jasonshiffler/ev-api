package com.tesla.springboot.evapi.exceptions;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException(){
        super("Vehicle not found");
    }

    public VehicleNotFoundException(Long id){
        super("Vehicle with {id} = " + id + " not found");
    }


}

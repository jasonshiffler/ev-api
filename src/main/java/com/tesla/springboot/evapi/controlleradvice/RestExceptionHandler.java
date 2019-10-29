package com.tesla.springboot.evapi.controlleradvice;

import com.tesla.springboot.evapi.exceptions.ApiError;
import com.tesla.springboot.evapi.exceptions.VehicleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<Object> handleVehicleNotFoundException(VehicleNotFoundException e){
        ApiError err = new ApiError(HttpStatus.NOT_FOUND,e);
        return new ResponseEntity<Object>(err,err.getStatus());
    }


}

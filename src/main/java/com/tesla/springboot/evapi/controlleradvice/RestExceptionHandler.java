/**
 * This class allows the exceptions to be handled so they print a cleanly formatted JSON message back to the client
 * and not a stack trace.
 */

package com.tesla.springboot.evapi.controlleradvice;

import com.tesla.springboot.evapi.exceptions.ApiError;
import com.tesla.springboot.evapi.exceptions.DataExpectedException;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.exceptions.TemperatureOutOfBoundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Object> handleItemNotFoundException(ItemNotFoundException e){
        ApiError err = new ApiError(HttpStatus.NOT_FOUND,e);
        return new ResponseEntity<Object>(err,err.getStatus());
    }

    @ExceptionHandler(TemperatureOutOfBoundsException.class)
    public ResponseEntity<Object> handleTempOutOfBoundsException(TemperatureOutOfBoundsException e){
        ApiError err = new ApiError(HttpStatus.BAD_REQUEST,e);
        return new ResponseEntity<Object>(err,err.getStatus());
    }

    @ExceptionHandler(DataExpectedException.class)
    public ResponseEntity<Object> handleDataExpectedException(DataExpectedException e){
        ApiError err = new ApiError(HttpStatus.BAD_REQUEST,e);
        return new ResponseEntity<Object>(err,err.getStatus());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException e){
        ApiError err = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"An internal error has occurred");
        return new ResponseEntity<Object>(err,err.getStatus());
    }

}

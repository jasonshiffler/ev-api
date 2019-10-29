package com.tesla.springboot.evapi.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiError {

    private HttpStatus status;
    private String message;

    public ApiError(HttpStatus status, RuntimeException e) {
        this.status = status;
        this.message = e.getMessage();
    }

}

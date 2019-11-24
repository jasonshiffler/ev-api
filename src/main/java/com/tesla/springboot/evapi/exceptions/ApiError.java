package com.tesla.springboot.evapi.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;

    public ApiError(HttpStatus status, Exception e) {
        this.status = status;
        this.message = e.getMessage();
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status, String s) {
        this.status = status;
        this.message = s;
        this.timestamp = LocalDateTime.now();
    }

}

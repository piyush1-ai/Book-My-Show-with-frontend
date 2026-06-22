package com.cfs.BookMyShow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
/*
    @ControllerAdvice + @ResponseBody
    - @ControllerAdvice: A specialization of @Component that allows you to define global exception handling
       , data binding, and model attributes for all controllers in your application.
    - @ResponseBody: Ensures that the methods inside return data directly as the HTTP response body (usually JSON),
    instead of resolving to a view.
    REST = Representational State Transfer
    ResponseEntity is a Spring Framework class that represents the entire HTTP response

 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handleRuntimeException(RuntimeException ex){

        Map<String ,Object> error = new HashMap<>();
        error.put("timeStamp", LocalDateTime.now());
        error.put("message",ex.getMessage());
        error.put("status", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleException(Exception ex){

        Map<String ,Object> error = new HashMap<>();
        error.put("timeStamp", LocalDateTime.now());
        error.put("message","something went worng" + ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.badRequest().body(error);
    }
}

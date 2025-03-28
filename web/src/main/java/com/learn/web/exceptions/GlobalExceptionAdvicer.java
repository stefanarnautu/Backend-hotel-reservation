package com.learn.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learn.service.exceptions.RoomAlreadyBooked;

@RestControllerAdvice
public class GlobalExceptionAdvicer {
    @ExceptionHandler(RuntimeException.class)
     public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>("Runtime: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(RoomAlreadyBooked.class)
     public ResponseEntity<String> handleRoomBookedException(RoomAlreadyBooked ex) {
        return new ResponseEntity<>("Room is booked: " + ex.getMessage(), HttpStatus.CONFLICT);
    }
}

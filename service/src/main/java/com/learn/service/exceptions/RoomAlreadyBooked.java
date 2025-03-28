package com.learn.service.exceptions;

public class RoomAlreadyBooked extends RuntimeException{
    public RoomAlreadyBooked(String message){
        super(message);
    }
}

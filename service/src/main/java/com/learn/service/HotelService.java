package com.learn.service;

import org.springframework.stereotype.Service;

import com.learn.repositories.HotelRepo;

@Service
public class HotelService {
    private final HotelRepo hotelRepo;

    public HotelService(HotelRepo hotelRepo){
        this.hotelRepo = hotelRepo;
    }

    
}

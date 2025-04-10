package com.learn.service;

import org.springframework.stereotype.Service;

import com.learn.repositories.HotelRepo;

@Service
public class HotelService {
    @SuppressWarnings("unused")
    private final HotelRepo hotelRepo;

    public HotelService(HotelRepo hotelRepo){
        this.hotelRepo = hotelRepo;
    }

    
}

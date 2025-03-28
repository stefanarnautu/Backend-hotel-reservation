package com.learn.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.domain.Room;
import com.learn.repositories.RoomRepo;

@Service
public class RoomService {
    private final RoomRepo roomRepo;

    public RoomService(RoomRepo roomRepo){
        this.roomRepo = roomRepo;
    }

    public Optional<Room> getRoomById(long id){
        return roomRepo.findById(id);
    }
}

package com.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.domain.Room;

public interface RoomRepo extends JpaRepository<Room,Long>{

}

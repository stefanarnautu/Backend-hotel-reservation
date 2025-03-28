package com.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.domain.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long>{

}

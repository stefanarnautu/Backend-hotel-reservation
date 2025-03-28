package com.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.domain.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation,Long>{

}

package com.learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.domain.Reservation;
import com.learn.domain.Room;
import com.learn.domain.User;
import com.learn.dto.requestDTO.ReservationRequestDTO;
import com.learn.dto.responseDTO.ReservationSavedDTO;
import com.learn.enums.PaymentType;
import com.learn.repositories.ReservationRepo;
import com.learn.repositories.RoomRepo;
import com.learn.repositories.UserRepo;
import com.learn.service.exceptions.RoomAlreadyBooked;

@Service
public class ReservationService {
    private final ReservationRepo reservationRepo;
    private final RoomRepo roomRepo;
    private final UserRepo userRepo;

    public ReservationService(ReservationRepo reservationRepo, RoomRepo roomRepo, UserRepo userRepo){
        this.reservationRepo = reservationRepo;
        this.roomRepo = roomRepo;
        this.userRepo= userRepo;
    }

    public List<Reservation> getAll(){
        return reservationRepo.findAll();
    }

    public ReservationSavedDTO createReservation(ReservationRequestDTO reservationDto){
        Room room = roomRepo.findById(reservationDto.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        User user = userRepo.findById(reservationDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        if(room.getReservation() != null){
            throw new RoomAlreadyBooked("Room " + reservationDto.getRoomId() + " is booked.");
        }
        Reservation reservation = new Reservation();
        reservation.setPaymentType(reservationDto.getPaymentType());
        reservation.setPrice(reservationDto.getPrice());
        reservation.setRoom(room);
        reservation.setUser(user);

        room.setReservation(reservation);
        reservationRepo.save(reservation);
        return new ReservationSavedDTO(reservation.getId(), reservation.getUser().getUsername(), reservation.getRoom().getHotel().getName(), reservation.getPrice());
    }
}

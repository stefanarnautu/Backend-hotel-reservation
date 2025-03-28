package com.learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.domain.Reservation;
import com.learn.domain.Room;
import com.learn.domain.User;
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

    public Reservation createReservation(long roomId, long userId, PaymentType paymentType, int price){
        Room room = roomRepo.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        if(room.getReservation() != null){
            throw new RoomAlreadyBooked("Room " + roomId + " is booked.");
        }
        Reservation reservation = new Reservation();
        reservation.setPaymentType(paymentType);
        reservation.setPrice(price);
        reservation.setRoom(room);
        reservation.setUser(user);

        room.setReservation(reservation);
        return reservationRepo.save(reservation);
    }
}

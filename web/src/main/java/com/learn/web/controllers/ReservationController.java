package com.learn.web.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.domain.Reservation;
import com.learn.service.ReservationService;
import com.learn.service.RoomService;
import com.learn.service.UserService;
import com.learn.web.requestDTO.ReservationRequestDTO;
import com.learn.web.requestDTO.ReservationSavedDTO;

@RestController
@RequestMapping("/auth/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService, RoomService roomService, UserService userService){
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationSavedDTO> addReservation(@RequestBody ReservationRequestDTO reservationRequest){
        Reservation savedReservation = reservationService.createReservation(reservationRequest.getRoomId(),
                                                                            reservationRequest.getUserId(),
                                                                            reservationRequest.getPaymentType(),
                                                                            reservationRequest.getPrice());
        return new ResponseEntity<>(new ReservationSavedDTO(savedReservation.getId(), savedReservation.getUser().getUsername(), savedReservation.getRoom().getHotel().getName(), savedReservation.getPrice()), HttpStatus.CREATED);
    }
}

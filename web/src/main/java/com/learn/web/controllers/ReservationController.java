package com.learn.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.domain.Reservation;
import com.learn.dto.requestDTO.ReservationRequestDTO;
import com.learn.dto.responseDTO.ReservationSavedDTO;
import com.learn.service.ReservationService;
import com.learn.service.RoomService;
import com.learn.service.UserService;

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

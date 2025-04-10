package com.learn.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.learn.dto.requestDTO.ReservationRequestDTO;
import com.learn.dto.responseDTO.ReservationSavedDTO;
import com.learn.service.ReservationService;

@RestController
@RequestMapping("/auth/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationSavedDTO> addReservation(@RequestBody ReservationRequestDTO reservationRequest){
        ReservationSavedDTO reservationResponse = reservationService.createReservation(reservationRequest);
        return new ResponseEntity<>(reservationResponse,HttpStatus.CREATED);
    }
}

package com.learn.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.learn.dto.requestDTO.ReservationRequestDTO;
import com.learn.dto.responseDTO.ReservationSavedDTO;
import com.learn.service.ReservationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/auth/reservations")
@SecurityRequirement(name = "bearerAuth")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @PostMapping
    @Operation(summary = "Create a nsew reservation", description = "Create a new reservation by providing the reservation details.")
    public ResponseEntity<ReservationSavedDTO> addReservation(@RequestBody ReservationRequestDTO reservationRequest){
        ReservationSavedDTO reservationResponse = reservationService.createReservation(reservationRequest);
        return new ResponseEntity<>(reservationResponse,HttpStatus.CREATED);
    }

    @DeleteMapping
    @Operation(summary = "Delete reservation", description = "Delete reservation")
    public ResponseEntity<ReservationSavedDTO> deleteReservation(){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

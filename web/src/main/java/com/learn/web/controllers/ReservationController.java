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
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/reservations")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Reservations", description = "Endpoints for managing hotel reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @PostMapping
    @Operation(
        summary = "Create a new reservation",
        description = "Create a new reservation by providing the reservation details.",
        responses = {
            @ApiResponse(responseCode = "201", description = "Reservation successfully created",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ReservationSavedDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
        }
    )
    public ResponseEntity<?> addReservation(@Valid @RequestBody ReservationRequestDTO reservationRequest){
        ReservationSavedDTO reservationResponse = reservationService.createReservation(reservationRequest);
        return new ResponseEntity<>(reservationResponse,HttpStatus.CREATED);
    }

    @DeleteMapping
    @Operation(summary = "Delete reservation", description = "Delete reservation")
    public ResponseEntity<Void> deleteReservation(){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

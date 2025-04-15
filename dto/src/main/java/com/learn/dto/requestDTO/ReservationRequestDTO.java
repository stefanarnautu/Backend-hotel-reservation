package com.learn.dto.requestDTO;

import com.learn.enums.PaymentType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReservationRequestDTO {
    @Schema(description = "ID of the room being reserved", example = "101")
    private Long roomId;
    
    @Schema(description = "ID of the user making the reservation", example = "42")
    private Long userId;
    
    @Schema(description = "Whould be CARD or CASH", example = "CARD")
    @NotNull(message = "Payment type must not be null")
    @Pattern(regexp = "CARD|CASH", message = "Payment type must be either CARD or CASH")
    private PaymentType paymentType;
    
    @Schema(description = "Amount for the reservation", example = "350")
    @Min(value = 1, message = "Price must be greater than zero")
    private int price;
}

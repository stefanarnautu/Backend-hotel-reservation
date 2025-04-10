package com.learn.dto.requestDTO;

import com.learn.enums.PaymentType;

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
    private long roomId;
    private long userId;
    private PaymentType paymentType;
    private int price;
}

package com.microservices.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddPaymentDTO {

    private String transactionId;
    private long patientId;
    private double amount;
}

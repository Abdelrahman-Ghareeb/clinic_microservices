package com.microservices.payment.mapper;

import com.microservices.payment.dto.AddPaymentDTO;
import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.model.Payment;

import java.util.UUID;

public class AddPaymentMapper {

    public static Payment mapToEntity(AddPaymentDTO paymentDto){
        return Payment.builder().transactionId(UUID.randomUUID().toString()).patientId(paymentDto.getPatientId()).amount(paymentDto.getAmount()).build();
    }

    public static AddPaymentDTO mapToDTO(Payment payment){
        return AddPaymentDTO.builder().transactionId(payment.getTransactionId()).patientId(payment.getPatientId()).amount(payment.getAmount()).build();
    }
}

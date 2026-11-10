package com.microservices.payment.mapper;

import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.model.Payment;

public class PaymentMapper {

    public static Payment mapToEntity(PaymentDto paymentDto){
        return Payment.builder().transactionId(paymentDto.getTransactionId()).patientId(paymentDto.getPatientId()).amount(paymentDto.getAmount()).build();
    }

    public static PaymentDto mapToDTO(Payment payment){
        return PaymentDto.builder().transactionId(payment.getTransactionId()).patientId(payment.getPatientId()).amount(payment.getAmount()).build();
    }
}

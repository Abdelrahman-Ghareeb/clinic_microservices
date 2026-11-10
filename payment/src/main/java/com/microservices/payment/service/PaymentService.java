package com.microservices.payment.service;

import com.microservices.payment.dto.AddPaymentDTO;
import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.mapper.AddPaymentMapper;
import com.microservices.payment.mapper.PaymentMapper;
import com.microservices.payment.model.Payment;
import com.microservices.payment.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentDto getPaymentById(String  transactionId) {

        Optional<Payment> paymentDtoOptional = paymentRepository.findByTransactionId(transactionId);


        return PaymentMapper.mapToDTO(paymentDtoOptional.get());
    }

    public AddPaymentDTO createPayment(AddPaymentDTO addPayment) {

        Payment payment = paymentRepository.save(AddPaymentMapper.mapToEntity(addPayment));
        return AddPaymentMapper.mapToDTO(payment);
    }
}

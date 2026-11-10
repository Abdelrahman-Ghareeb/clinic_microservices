package com.microservices.doctor.service;

import com.microservices.doctor.dto.AddPaymentDTO;
import com.microservices.doctor.dto.PaymentDto;
import com.microservices.doctor.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentProxy paymentProxy;


    public PaymentDto getPaymentById(String transactionId) {
        return paymentProxy.getPaymentById(transactionId);
    }

    public AddPaymentDTO createPayment(AddPaymentDTO addPayment) {
        return paymentProxy.createPayment(addPayment);
    }
}

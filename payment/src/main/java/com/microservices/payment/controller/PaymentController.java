package com.microservices.payment.controller;

import com.microservices.payment.dto.AddPaymentDTO;
import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{transactionId}")
    public PaymentDto getPaymentById(@PathVariable String transactionId) {
        return paymentService.getPaymentById(transactionId);
    }

    @PostMapping()
    public AddPaymentDTO createPayment(@RequestBody AddPaymentDTO addPayment) {
        return paymentService.createPayment(addPayment);
    }
}

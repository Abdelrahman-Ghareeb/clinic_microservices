package com.microservices.doctor.controller;

import com.microservices.doctor.dto.AddPaymentDTO;
import com.microservices.doctor.dto.PaymentDto;
import com.microservices.doctor.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorPaymentController {

    @Autowired
private PaymentService paymentService;


    @GetMapping("/payment/{transactionId}")
    public PaymentDto getPaymentById(@PathVariable String transactionId) {
        return paymentService.getPaymentById(transactionId);
    }

    @PostMapping("/payment")
    public AddPaymentDTO createPayment(@RequestBody AddPaymentDTO addPayment) {
        return paymentService.createPayment(addPayment);
    }
}

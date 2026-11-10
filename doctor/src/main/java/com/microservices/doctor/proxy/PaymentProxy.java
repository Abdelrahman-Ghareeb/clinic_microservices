package com.microservices.doctor.proxy;

import com.microservices.doctor.dto.AddPaymentDTO;
import com.microservices.doctor.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentProxy {

    @GetMapping("/payment/{transactionId}")
    public PaymentDto getPaymentById(@PathVariable String transactionId);

    @PostMapping("/payment")
    public AddPaymentDTO createPayment(@RequestBody AddPaymentDTO addPayment) ;

}

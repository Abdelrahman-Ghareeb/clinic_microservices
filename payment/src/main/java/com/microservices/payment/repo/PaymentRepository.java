package com.microservices.payment.repo;

import com.microservices.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {


    Optional<Payment> findByTransactionId(String transactionId );
}

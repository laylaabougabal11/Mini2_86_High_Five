package com.example.miniapp.repositories;

import com.example.miniapp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find all payments linked to a specific trip ID
    List<Payment> findByTripId(Long tripId);

    // Find all payments where the amount exceeds the given threshold
    List<Payment> findByAmountGreaterThan(Double threshold);
}

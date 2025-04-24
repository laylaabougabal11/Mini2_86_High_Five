package com.example.miniapp.services;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // 8.4.2.1 Add Payment
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // 8.4.2.2 Get All Payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // 8.4.2.3 Get Payment By ID
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
    }

    // 8.4.2.4 Update Payment
    public Payment updatePayment(Long id, Payment payment) {
        Payment existing = getPaymentById(id);
        existing.setAmount(payment.getAmount());
        existing.setPaymentMethod(payment.getPaymentMethod());
        existing.setPaymentStatus(payment.getPaymentStatus());
        existing.setTrip(payment.getTrip());
        return paymentRepository.save(existing);
    }

    // 8.4.2.5 Delete Payment
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    // 8.4.2.6 Find Payments By Trip ID
    public List<Payment> findPaymentsByTripId(Long tripId) {
        return paymentRepository.findByTripId(tripId);
    }

    // 8.4.2.7 Find Payments With an Amount Greater Than a Threshold
    public List<Payment> findPaymentsWithAmountGreaterThan(Double threshold) {
        return paymentRepository.findByAmountGreaterThan(threshold);
    }
}

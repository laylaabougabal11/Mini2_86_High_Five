package com.example.miniapp.controllers;

import com.example.miniapp.models.Payment;
import com.example.miniapp.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // 9.4.2.1 Add Payment
    @PostMapping("/addPayment")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }

    // 9.4.2.2 Get All Payments
    @GetMapping("/allPayments")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // 9.4.2.3 Get Specific Payment
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // 9.4.2.4 Update Payment
    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    // 9.4.2.5 Delete Payment
    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment deleted with id " + id;
    }

    // 9.4.2.6 Find Payments By Trip ID
    @GetMapping("/findByTripId")
    public List<Payment> findPaymentsByTripId(@RequestParam Long tripId) {
        return paymentService.findPaymentsByTripId(tripId);
    }

    // 9.4.2.7 Find Payments With an Amount Greater Than a Threshold
    @GetMapping("/findByAmountThreshold")
    public List<Payment> findPaymentsWithAmountGreaterThan(@RequestParam Double threshold) {
        return paymentService.findPaymentsWithAmountGreaterThan(threshold);
    }
}

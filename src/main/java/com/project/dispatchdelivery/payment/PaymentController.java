package com.project.dispatchdelivery.payment;

import com.project.dispatchdelivery.db.entity.PaymentEntity;
import com.project.dispatchdelivery.model.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    @ResponseStatus(value = HttpStatus.OK)
    public PaymentEntity makePayment(@RequestBody PaymentEntity paid) {
        PaymentEntity dbPayment = paymentService.makePayment(paid);
        return dbPayment;
    }
}

package com.project.dispatchdelivery.payment;

import com.project.dispatchdelivery.db.PaymentRepository;
import com.project.dispatchdelivery.db.entity.PaymentEntity;
import com.project.dispatchdelivery.model.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {

        this.paymentRepository = paymentRepository;
    }

    public PaymentEntity makePayment(PaymentEntity paid) {

        paymentRepository.createPayment(
                paid.cardNumber(),
                paid.holderName(),
                paid.expiredDate(),
                paid.cvv(),
                paid.billingAddress(),
                paid.city(),
                paid.state(),
                paid.zipCode()
        );
        return paid;
    }
}

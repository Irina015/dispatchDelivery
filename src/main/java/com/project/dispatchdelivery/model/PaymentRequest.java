package com.project.dispatchdelivery.model;

import org.springframework.data.annotation.Id;

public record PaymentRequest (
        String cardNumber,
        String holderName,
        String expiredDate,
        String cvv,
        String billingAddress,
        String city,
        String state,
        String zipCode
){
}

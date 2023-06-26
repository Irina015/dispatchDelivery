package com.project.dispatchdelivery.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "payment")
public record PaymentEntity(
        @Id long id,
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

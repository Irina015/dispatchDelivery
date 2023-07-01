package com.project.dispatchdelivery.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;




@Table(name = "orders")
public record OrderEntity(

        @Id Long id,
        Long userId,
        String senderAddress,
        String senderCity,
        String senderState,
        String senderEmail,
        String senderPhone,
        String receiverAddress,
        String receiverCity,
        String receiverState,
        String receiverEmail,
        String receiverPhone
) {
}

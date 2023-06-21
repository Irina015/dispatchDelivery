package com.project.dispatchdelivery.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("orders")
public record OrderEntity(
        @Id Long id,
        Long userId,
        String fromLocation,
        String toLocation,
        String pickupDate,
        String deliveryDate
) {
}

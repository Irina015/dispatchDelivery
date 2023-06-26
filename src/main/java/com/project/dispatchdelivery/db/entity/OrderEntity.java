package com.project.dispatchdelivery.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;




@Table(name = "orders")
public record OrderEntity(

        @Id Long id,
        Long userId,
        @JsonProperty("from_location")
        String fromLocation,
        @JsonProperty("to_location")
        String toLocation,
        @JsonProperty("pickup_date")
        String pickupDate,
        @JsonProperty("delivery_date")
        String deliveryDate
) {
}

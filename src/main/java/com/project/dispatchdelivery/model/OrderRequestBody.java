package com.project.dispatchdelivery.model;
import com.fasterxml.jackson.annotation.JsonProperty;


public record OrderRequestBody(
        @JsonProperty("user_id")
        Long userId,
        @JsonProperty("from_location")
        String fromLocation,
        @JsonProperty("to_location")
        String toLocation,
        @JsonProperty("pickup_date")
        String pickupDate,
        @JsonProperty("delivery_date")
        String deliveryDate
)
{

}

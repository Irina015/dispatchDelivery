package com.project.dispatchdelivery.db.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("delivery_options")
public record DeliveryOptionsEntity (
        String deliveryType,
        String serviceType,
        Date deliverySchedule,
        Date pickUpTime,
        int dispatcherId,
        double price,
        double originLat,
        double originLng,
        double destinationLat,
        double destinationLng
){
}

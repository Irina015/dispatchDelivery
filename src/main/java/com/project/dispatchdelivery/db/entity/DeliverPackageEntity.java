package com.project.dispatchdelivery.db.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("DeliverPackage")
public record DeliverPackageEntity (
        int id,
        ShoppingCartEntity shoppingCart,
        double weight,
        boolean canDeliver,
        String packageType,
        String packageId,
        String shippingFrom,
        String shippingTo,
        String deliveryType,
        String serviceType,
        String deliveryTime,
        String pickUpTime,
        String dispatcherId,
        double cost,
        String orderId,
        String packageDescription,
        double dispatcherLat,
        double dispatcherlng,
        String size,
        double originLat,
        double originLng,
        double destinationLat,
        double destinationLng,
        Date createdTime
){
}

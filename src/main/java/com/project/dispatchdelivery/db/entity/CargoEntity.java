package com.project.dispatchdelivery.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("cargo")
public record CargoEntity (
        @Id int id,
        double weight,
        double length,
        double width,
        double height,
        int priority,
        String shippingFromCoordinate,
        String shippingToCoordinate,
        boolean shipped,
        Date PickupDate
){
}

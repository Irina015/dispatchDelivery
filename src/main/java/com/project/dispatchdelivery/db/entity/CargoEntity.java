package com.project.dispatchdelivery.db.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("Cargo")
public record CargoEntity (
        double weight,
        int length,
        int width,
        int height,
        int priority,
        String shippingFromCoordinate,
        String shippingToCoordinate,
        boolean shipped,
        Date PicupDate
){
}

package com.project.dispatchdelivery.db.entity;

import com.project.dispatchdelivery.db.CargoRepository;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("ShoppingCart")
public record ShoppingCartEntity (
        int id,
        List<CargoRepository> purchasedGoods,
        int quantity,
        double totalCost
){
}

package com.project.dispatchdelivery.db.entity;

import com.project.dispatchdelivery.db.CargoRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("shopping_cart")
public record ShoppingCartEntity (
        @Id int id,
        List<CargoRepository> purchasedGoods,
        int quantity,
        double totalCost
){
}

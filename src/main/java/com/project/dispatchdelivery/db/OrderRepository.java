package com.project.dispatchdelivery.db;

import com.project.dispatchdelivery.db.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Long> {

}

package com.project.dispatchdelivery.db;

import com.project.dispatchdelivery.db.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Long> {
    //add search order by userid
    //add delete query (need to use @Modifying annotation)
}

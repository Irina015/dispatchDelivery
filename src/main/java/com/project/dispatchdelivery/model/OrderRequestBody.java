package com.project.dispatchdelivery.model;

import com.project.dispatchdelivery.db.entity.OrderEntity;

public record OrderRequestBody(
        OrderEntity order
)
{

}

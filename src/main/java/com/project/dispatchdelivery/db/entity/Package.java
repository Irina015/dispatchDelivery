package com.project.dispatchdelivery.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("package")
public record Package(
        @Id Long id,
        Long orderId,
        String weight,
        String height,
        String width,
        String length
) {
}

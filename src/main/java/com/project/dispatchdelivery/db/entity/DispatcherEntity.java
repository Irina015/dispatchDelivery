package com.project.dispatchdelivery.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("dispatcher")
public record DispatcherEntity(
        @Id int dispatcherId,
        String longtitue,
        String latitute
) {
}

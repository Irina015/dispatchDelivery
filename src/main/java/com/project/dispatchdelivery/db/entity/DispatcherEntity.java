package com.project.dispatchdelivery.db.entity;

import org.springframework.data.relational.core.mapping.Table;

@Table("Dispatcher")
public record DispatcherEntity(
        int dispatcherId,
        String longtitue,
        String latitute
) {
}

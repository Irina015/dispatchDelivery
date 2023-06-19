package com.project.dispatchdelivery.db.entity;


import org.springframework.data.relational.core.mapping.Table;

@Table("headquarter")
public record Headquarter(
        String headquarterId,
        String longtitue,
        String latitute
) {
}

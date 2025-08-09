package com.one.compass.utils.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class Auditable {

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Long createdAt;

    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    private Long createdBy;

    @Column(name = "UPDATED_AT", nullable = false)
    private Long updatedAt;

    @Column(name = "UPDATED_BY", nullable = false)
    private Long updatedBy;

    @PrePersist
    protected void prePersist() {
        createdAt = System.currentTimeMillis() / 1000;
        createdBy = 0L;
        updatedAt = System.currentTimeMillis() / 1000;
        updatedBy = 0L;
    }

    @PreUpdate
    protected void preUpdate() {
        updatedAt = System.currentTimeMillis() / 1000;
        updatedBy = 0L;
    }
}

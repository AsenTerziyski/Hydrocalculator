package com.example.hydrocalc.model.entities;

import org.springframework.boot.context.config.ConfigDataEnvironmentUpdateListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
    private Long id;
    private LocalDateTime created;
    private LocalDateTime modified;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public LocalDateTime getCreated() {
        return created;
    }

    public BaseEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public BaseEntity setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @PrePersist
    public void beforeCreate() {
        this.created = LocalDateTime.now();
    }

    @PostPersist
    public void OnUpdate() {
        this.modified = LocalDateTime.now();
    }

}

package com.E3N.domain.category;

import com.E3N.domain.validation.Error;
import com.E3N.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category {
    private final String id;
    private final String name;
    private final String description;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;

    private Category(
            final String id,
            final String name,
            final String description,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletesAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletesAt;
    }

    public static Category with(
            final String id,
            final String name,
            final String description,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt) {
        return new Category(
                id, name, description, active, createdAt, updatedAt, deletedAt
        );
    }

    public static Category with(final Category category) {
        return with(
                category.id(),
                category.name(),
                category.description(),
                category.active(),
                category.createdAt(),
                category.updatedAt(),
                category.deletedAt()
        );
    }

    public Category validate(final ValidationHandler handler) {
        if (id == null || id.isBlank()) {
            handler.append(new Error("'id' should not be null"));
        }
        if (name == null || name.isBlank()) {
            handler.append(new Error("'name' should not be null"));
        }
        return this;
    }


    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public boolean active() {
        return active;
    }

    public Instant createdAt() {
        return createdAt;
    }

    public Instant updatedAt() {
        return updatedAt;
    }

    public Instant deletedAt() {
        return deletedAt;
    }
}

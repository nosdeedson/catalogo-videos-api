package com.E3N.domain.genre;

import com.E3N.domain.validation.Error;
import com.E3N.domain.validation.ValidationHandler;
import com.E3N.domain.validation.handler.ThrowsValidationHandler;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Genre {

    private final String id;
    private final String name;
    private final boolean active;
    private final Set<String> categories;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;


    private Genre(
            final String id,
            final String name,
            final boolean active,
            final Set<String> categories,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.categories = categories != null ? categories : new HashSet<>();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        validate(new ThrowsValidationHandler());
    }

    public static Genre with(
            final String id,
            final String name,
            final boolean active,
            final Set<String> categories,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ){
        return new Genre(id, name, active, categories, createdAt, updatedAt, deletedAt);
    }

    public static Genre with(final Genre genre){
        return with(
                genre.id,
                genre.name,
                genre.active,
                genre.categories,
                genre.createdAt,
                genre.updatedAt,
                genre.updatedAt
        );
    }

    public void validate(final ValidationHandler handler){
        if (id == null || id.isBlank()){
            handler.append(new Error("'id' should not be empty"));
        }
        if (name == null || name.isBlank()){
            handler.append(new Error("'name' should not be empty"));
        }
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public boolean active() {
        return active;
    }

    public Set<String> categories() {
        return categories;
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

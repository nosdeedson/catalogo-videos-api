package com.E3N.domain.castMember;

import com.E3N.domain.validation.Error;
import com.E3N.domain.validation.ValidationHandler;

import java.time.Instant;

public class CastMember {

    private final String id;
    private final String name;
    private final CastMemberType type;
    private final Instant createdAt;
    private final Instant updatedAt;

    private CastMember(
            final String id,
            final String name,
            final CastMemberType type,
            final Instant createdAt,
            final Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static CastMember with(
            final String id,
            final String name,
            final CastMemberType type,
            final Instant createdAt,
            final Instant updatedAt){
        return new CastMember(id, name, type, createdAt, updatedAt);
    }

    public static CastMember with(CastMember castMember){
        return with(
                castMember.id(),
                castMember.name(),
                castMember.type(),
                castMember.createdAt,
                castMember.updatedAt()
        );
    }

    public void validate(final ValidationHandler handler){
        if (id == null || id.isBlank()){
            handler.append(new Error("'id' should not be null"));
        }
        if (name == null || name.isBlank()){
            handler.append(new Error("'name' should not be null"));
        }
        if (type == null ){
            handler.append(new Error("'type' should not be null"));
        }
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public CastMemberType type() {
        return type;
    }

    public Instant createdAt() {
        return createdAt;
    }

    public Instant updatedAt() {
        return updatedAt;
    }
}

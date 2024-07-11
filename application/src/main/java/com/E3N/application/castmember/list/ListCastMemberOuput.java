package com.E3N.application.castmember.list;

import com.E3N.domain.castMember.CastMember;
import com.E3N.domain.castMember.CastMemberType;

import java.time.Instant;

public record ListCastMemberOuput(
        String id,
        String name,
        CastMemberType type,
        Instant createdAt,
        Instant updatedAt
) {
    public static ListCastMemberOuput from(CastMember member){
        return new ListCastMemberOuput(
                member.id(),
                member.name(),
                member.type(),
                member.createdAt(),
                member.updatedAt()
        );
    }
}

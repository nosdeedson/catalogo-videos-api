package com.E3N.domain.castMember;

public record CastMemberSearchQuery(
        int page,
        int perPage,
        String terms,
        String sort,
        String direction
) {
}

package com.E3N.domain.castMember;

import com.E3N.domain.pagination.Pagination;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CastMemberGateway {
    CastMember save(final CastMember castMember);

    void deleteById(final String id);

    Optional<CastMember> findById(final String id);

    Set<CastMember> findAllById(final Set<String> ids);

    Pagination<CastMember> findAll(CastMemberSearchQuery query);
}

package com.E3N.application.castmember.list;

import com.E3N.application.UseCase;
import com.E3N.domain.castMember.CastMemberGateway;
import com.E3N.domain.castMember.CastMemberSearchQuery;
import com.E3N.domain.pagination.Pagination;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ListCastMemberUseCase extends UseCase<CastMemberSearchQuery, Pagination<ListCastMemberOuput>> {

    private final CastMemberGateway castMemberGateway;

    public ListCastMemberUseCase(CastMemberGateway castMemberGateway) {
        this.castMemberGateway = Objects.requireNonNull(castMemberGateway);
    }

    @Override
    public Pagination<ListCastMemberOuput> execute(CastMemberSearchQuery anIn) {
        return castMemberGateway.findAll(anIn)
                .map(ListCastMemberOuput::from);
    }
}

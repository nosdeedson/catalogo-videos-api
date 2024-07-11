package com.E3N.application.castmember.get;

import com.E3N.application.UseCase;
import com.E3N.domain.castMember.CastMember;
import com.E3N.domain.castMember.CastMemberGateway;
import com.E3N.domain.castMember.CastMemberType;
import com.E3N.domain.genre.Genre;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GetAllCastMembersByIdUseCase extends UseCase<GetAllCastMembersByIdUseCase.Input, List<GetAllCastMembersByIdUseCase.OutPut>> {

    private final CastMemberGateway castMemberGateway;

    public GetAllCastMembersByIdUseCase(CastMemberGateway castMemberGateway) {
        this.castMemberGateway = castMemberGateway;
    }

    @Override
    public List<OutPut> execute(Input anIn) {
        if(anIn.ids().isEmpty()){
            return List.of();
        }
        return castMemberGateway.findAllById(anIn.ids)
                .stream()
                .map(OutPut::new)
                .toList();
    }

    public record Input(Set<String> ids){
        @Override
        public Set<String> ids() {
            return ids != null ? ids : Collections.emptySet();
        }
    }

    public record OutPut(
      String id,
      String name,
      CastMemberType type,
      Instant createdAt,
      Instant updatedAt
    ){
        public OutPut(final CastMember member) {
            this(
                    member.id(),
                    member.name(),
                    member.type(),
                    member.createdAt(),
                    member.updatedAt()
            );
        }
    }
}

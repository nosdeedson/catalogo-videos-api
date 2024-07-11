package com.E3N.application.castmember.delete;

import com.E3N.application.UnitUseCase;
import com.E3N.domain.castMember.CastMemberGateway;

import java.util.Objects;

public class DeleteCastMemberUseCase extends UnitUseCase<String> {

    private final CastMemberGateway castMemberGateway;

    public DeleteCastMemberUseCase(CastMemberGateway castMemberGateway) {
        this.castMemberGateway = Objects.requireNonNull(castMemberGateway);
    }

    @Override
    public void execute(String anIn) {
        if (anIn == null){
            return;
        }
        this.castMemberGateway.deleteById(anIn);
    }
}

package com.E3N.application.castmember.save;

import com.E3N.application.UseCase;
import com.E3N.domain.castMember.CastMember;
import com.E3N.domain.castMember.CastMemberGateway;
import com.E3N.domain.exceptions.NotificationException;
import com.E3N.domain.validation.Error;
import com.E3N.domain.validation.handler.Notification;

import java.util.Objects;

public class SaveCastMemberUseCase extends UseCase<CastMember, CastMember> {

    private final CastMemberGateway castMemberGateway;

    public SaveCastMemberUseCase(CastMemberGateway castMemberGateway) {
        this.castMemberGateway = Objects.requireNonNull(castMemberGateway);
    }

    @Override
    public CastMember execute(CastMember anIn) {
        if (anIn == null){
            throw NotificationException.with(new Error("'castMember' can not be null"));
        }
        final var notification = Notification.create();
        anIn.validate(notification);
        if (notification.hasError()){
            throw NotificationException.with("Invalid Castmember", notification);
        }
        return castMemberGateway.save(anIn);
    }
}

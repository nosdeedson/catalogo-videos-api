package com.E3N.application.castmember.save;

import com.E3N.application.UseCaseTest;
import com.E3N.domain.Fixture;
import com.E3N.domain.castMember.CastMember;
import com.E3N.domain.castMember.CastMemberGateway;
import com.E3N.domain.castMember.CastMemberType;
import com.E3N.domain.exceptions.DomainException;
import com.E3N.domain.utils.IdUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.Instant;

public class SaveCastMemberUseCaseTest extends UseCaseTest {

    @Mock
    private CastMemberGateway castMemberGateway;

    @InjectMocks
    private SaveCastMemberUseCase useCase;

    @Test
    public void testDependencies(){
        Assertions.assertNotNull(castMemberGateway);
        Assertions.assertNotNull(useCase);
    }
    @Test
    public void givenValidCastMember_whenCallsSave_shouldPersistIt() {
        final var member = Fixture.CastMembers.gabriel();

        Mockito.when(castMemberGateway.save(Mockito.any()))
                .thenReturn(member);

        final var output = useCase.execute(member);
        Assertions.assertEquals(member, output);
        Mockito.verify(castMemberGateway, Mockito.times(1)).save(Mockito.eq(member));
    }

    @Test
    public void givenNullCastMember_whenCallsSave_shouldReturnError() {
        final CastMember member = null;

        final var error = Assertions.assertThrows(DomainException.class, () -> useCase.execute(member));
        Assertions.assertEquals(error.getErrors().get(0).message(), "'castMember' can not be null");
        Assertions.assertEquals(1, error.getErrors().size());
        Mockito.verify(castMemberGateway, Mockito.times(0)).save(Mockito.eq(member));
    }

    @Test
    public void givenInvalidId_whenCallsSave_shouldReturnError() {
        final var member = CastMember.with(null, "eva mendes", CastMemberType.ACTRESS, Instant.now(), Instant.now());

        final var error = Assertions.assertThrows(DomainException.class, () -> useCase.execute(member));

        Assertions.assertEquals(error.getErrors().get(0).message() , "'id' should not be null");
        Assertions.assertEquals(error.getErrors().size(),  1);

        Mockito.verify(castMemberGateway, Mockito.times(0)).save(Mockito.eq(member));
    }

    @Test
    public void givenInvalidName_whenCallsSave_shouldReturnError() {
        final var member = CastMember.with(IdUtils.uniqueId(), null, CastMemberType.ACTRESS, Instant.now(), Instant.now());

        final var error = Assertions.assertThrows(DomainException.class, () -> useCase.execute(member));

        Assertions.assertEquals(error.getErrors().get(0).message() , "'name' should not be null");
        Assertions.assertEquals(error.getErrors().size(),  1);

        Mockito.verify(castMemberGateway, Mockito.times(0)).save(Mockito.eq(member));
    }
}

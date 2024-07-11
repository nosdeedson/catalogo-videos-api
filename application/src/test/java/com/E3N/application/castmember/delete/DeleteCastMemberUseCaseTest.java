package com.E3N.application.castmember.delete;

import com.E3N.application.UseCaseTest;
import com.E3N.domain.Fixture;
import com.E3N.domain.castMember.CastMemberGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class DeleteCastMemberUseCaseTest extends UseCaseTest {

    @InjectMocks
    private DeleteCastMemberUseCase useCase;

    @Mock
    private CastMemberGateway castMemberGateway;

    @Test
    public void testInjections(){
        Assertions.assertNotNull(castMemberGateway);
        Assertions.assertNotNull(useCase);
    }

    @Test
    public void givenValidId_whenCallsDelete_shouldBeOk() {
        final var aulas = Fixture.CastMembers.gabriel();
        final var expectedId = aulas.id();

        Mockito.doNothing()
                .when(this.castMemberGateway).deleteById(Mockito.anyString());

        Assertions.assertDoesNotThrow(() -> this.useCase.execute(expectedId));

        Mockito.verify(this.castMemberGateway, Mockito.times(1))
                .deleteById(Mockito.eq(expectedId));
    }

    @Test
    public void givenInvalidId_whenCallsDelete_shouldBeOk() {
        final String expectedId = null;
        Assertions.assertDoesNotThrow(() -> useCase.execute(expectedId));

        Mockito.verify(this.castMemberGateway, Mockito.never())
                .deleteById(Mockito.eq(expectedId));
    }

}

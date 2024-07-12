package com.E3N.application.castmember.get;

import com.E3N.application.UseCaseTest;
import com.E3N.domain.Fixture;
import com.E3N.domain.castMember.CastMember;
import com.E3N.domain.castMember.CastMemberGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GetAllCastMemberByIdUseCaseTest extends UseCaseTest {

    @InjectMocks
    private GetAllCastMembersByIdUseCase useCase;

    @Mock
    private CastMemberGateway castMemberGateway;

    @Test
    public void testDependency(){
        Assertions.assertNotNull(useCase);
        Assertions.assertNotNull(castMemberGateway);
    }

    @Test
    public void givenValidIds_whenCallsGetAllById_shouldReturnIt() {
        final var members = Set.of(
                Fixture.CastMembers.gabriel(),
                Fixture.CastMembers.leonan()
        );
        final var expectedItems = members.stream()
                .map(GetAllCastMembersByIdUseCase.OutPut::new)
                .collect(Collectors.toSet());
        final var expectedIds = members.stream()
                .map(CastMember::id)
                .collect(Collectors.toSet());

        Mockito.when(this.castMemberGateway.findAllById(Mockito.any()))
                .thenReturn(members);
        final var input = new GetAllCastMembersByIdUseCase.Input(expectedIds);
        final var output = this.useCase.execute(input);

        Assertions.assertTrue(
                output.size() == 2 && output.containsAll(expectedItems)
        );

        Mockito.verify(castMemberGateway, Mockito.times(1)).findAllById(expectedIds);
    }

    @Test
    public void givenNullIds_whenCallsGetAllById_shouldReturnEmpty() {
        final Set<String> ids = null;
        Mockito.when(castMemberGateway.findAllById(Mockito.any()))
                .thenReturn(Set.of());

        final var input = new GetAllCastMembersByIdUseCase.Input(ids);
        final var output = useCase.execute(input);
        Assertions.assertTrue(output.isEmpty());
        Mockito.verify(castMemberGateway, Mockito.times(0)).findAllById(ids);
    }
}

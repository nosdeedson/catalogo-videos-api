package com.E3N.application.castmember.list;

import com.E3N.application.UseCaseTest;
import com.E3N.domain.Fixture;
import com.E3N.domain.castMember.CastMember;
import com.E3N.domain.castMember.CastMemberGateway;
import com.E3N.domain.castMember.CastMemberSearchQuery;
import com.E3N.domain.pagination.Pagination;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class ListCastMemberUseCaseTest extends UseCaseTest {

    @InjectMocks
    private ListCastMemberUseCase useCase;

    @Mock
    private CastMemberGateway castMemberGateway;

    @Test
    public void testDependencies() {
        Assertions.assertNotNull(useCase);
        Assertions.assertNotNull(castMemberGateway);
    }

    @Test
    public void givenValidQuery_whenCallsListCastMembers_shouldReturnIt() {
        final var members = List.of(
                Fixture.CastMembers.gabriel(),
                Fixture.CastMembers.leonan()
        );

        final var expectedMembers = members.stream()
                .map(ListCastMemberOuput::from)
                .toList();

        final var expectedPage = 1;
        final var expectedPerPage = 10;
        final var expectedTerms = "";
        final var expectedSort = "";
        final var expectedDirections = "desc";
        final var expectedItemsCount = 2;

        final var query = new CastMemberSearchQuery(expectedPage, expectedPerPage, expectedTerms, expectedSort, expectedDirections);
        final var pagination = new Pagination<CastMember>(expectedPage, expectedPerPage, members.size(), members);
        Mockito.when(castMemberGateway.findAll(query))
                .thenReturn(pagination);

        final var output = useCase.execute(query);

        Assertions.assertTrue(output.data().size() == expectedItemsCount && output.data().containsAll(expectedMembers));
        Mockito.verify(castMemberGateway, Mockito.times(1)).findAll(query);

    }


}

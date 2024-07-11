package com.E3N.domain.castmember;

import com.E3N.domain.UnitTest;
import com.E3N.domain.castMember.CastMember;
import com.E3N.domain.castMember.CastMemberType;
import com.E3N.domain.exceptions.DomainException;
import com.E3N.domain.utils.InstantUtils;
import com.E3N.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CastMemberTest extends UnitTest {

    @Test
    public void givenValidParams_whenCallWith_thenInstantiateCastMember() {
        final var expectedId = UUID.randomUUID().toString();
        final var expectedName = "Eva Mendes";
        final var expectedType = CastMemberType.ACTRESS;
        final var expectedDates = InstantUtils.now();

        final var member = CastMember.with(expectedId, expectedName, expectedType, expectedDates, expectedDates);

        Assertions.assertNotNull(member);
        Assertions.assertEquals(expectedId, member.id());
        Assertions.assertEquals(expectedName, member.name());
        Assertions.assertEquals(expectedType, member.type());
        Assertions.assertEquals(expectedDates, member.createdAt());
        Assertions.assertEquals(expectedDates, member.updatedAt());
    }

    @Test
    public void givenValidParams_whenCallWithCategory_thenInstantiateACastMember() {
        final var expectedId = UUID.randomUUID().toString();
        final var expectedName = "Eva Mendes";
        final var expectedType = CastMemberType.ACTRESS;
        final var expectedDates = InstantUtils.now();

        final var categoryOrigin = CastMember.with(expectedId, expectedName, expectedType, expectedDates, expectedDates);

        final var category = CastMember.with(categoryOrigin);

        Assertions.assertNotNull(category);
        Assertions.assertEquals(expectedId, category.id());
        Assertions.assertEquals(expectedName, category.name());
        Assertions.assertEquals(expectedType, category.type());
        Assertions.assertEquals(expectedDates, category.createdAt());
        Assertions.assertEquals(expectedDates, category.updatedAt());
    }

    @Test
    public void givenAnInvalidNullName_whenCallNewCastMemberAndValidate_thenShouldReceiveError() {
        final var expectedId = UUID.randomUUID().toString();
        final var expectedType = CastMemberType.UNKNOWN;
        final var expectedDates = InstantUtils.now();
        final var expectedErrorCount = 1;
        final var expectedMessage = "'name' should not be null";

        final var category = CastMember.with(expectedId, null, expectedType, expectedDates, expectedDates);

        final var error = Assertions.assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        Assertions.assertEquals(expectedErrorCount, error.getErrors().size());
        Assertions.assertEquals(expectedMessage, error.getMessage());

    }

    @Test
    public void givenAnEmptyName_whenCallNewCastMemberAndValidate_thenShouldReceiveError() {
        final var expectedId = UUID.randomUUID().toString();
        final String expectedName = "";
        final var expectedType = CastMemberType.UNKNOWN;
        final var expectedDates = InstantUtils.now();
        final var expectedErrorCount = 1;
        final var expectedMessage = "'name' should not be null";

        final var category = CastMember.with(expectedId, expectedName, expectedType, expectedDates, expectedDates);

        final var error = Assertions.assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        Assertions.assertEquals(expectedErrorCount, error.getErrors().size());
        Assertions.assertEquals(expectedMessage, error.getMessage());
    }

    @Test
    public void givenANullId_whenCallNewCastMemberAndValidate_thenShouldReceiveError() {
        final var expectedName = "Eva Mendes";
        final var expectedType = CastMemberType.ACTRESS;
        final var expectedDates = InstantUtils.now();
        final var expectedErrorCount = 1;
        final var expectedMessage = "'id' should not be null";

        final var category = CastMember.with(null, expectedName, expectedType, expectedDates, expectedDates);

        final var error = Assertions.assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        Assertions.assertEquals(expectedErrorCount, error.getErrors().size());
        Assertions.assertEquals(expectedMessage, error.getMessage());
    }

    @Test
    public void givenAnEmptyId_whenCallNewCastMemberAndValidate_thenShouldReceiveError() {
        final var expectedName = "Eva Mendes";
        final var expectedType = CastMemberType.ACTRESS;
        final var expectedDates = InstantUtils.now();
        final var expectedErrorCount = 1;
        final var expectedMessage = "'id' should not be null";

        final var category = CastMember.with(null, expectedName, expectedType, expectedDates, expectedDates);

        final var error = Assertions.assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        Assertions.assertEquals(expectedErrorCount, error.getErrors().size());
        Assertions.assertEquals(expectedMessage, error.getMessage());
    }
}
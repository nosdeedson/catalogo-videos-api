package com.E3N.domain.category;

import com.E3N.domain.UnitTest;
import com.E3N.domain.exceptions.DomainException;
import com.E3N.domain.utils.InstantUtils;
import com.E3N.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CategoryTest extends UnitTest {

    @Test
    public void givenValidParams_whenCallWith_thenInstantiateCategory() {
        final var expectedId = UUID.randomUUID().toString();
        final var expectedName = "Filmes";
        final var expectedDescription = "Category most viewed";
        final var expectedIsActive = true;
        final var expectedDates = InstantUtils.now();

        final var category = Category.with(expectedId, expectedName, expectedDescription, expectedIsActive, expectedDates, expectedDates, null);

        Assertions.assertNotNull(category);
        Assertions.assertEquals(expectedId, category.id());
        Assertions.assertEquals(expectedName, category.name());
        Assertions.assertEquals(expectedDescription, category.description());
        Assertions.assertTrue(expectedIsActive);
        Assertions.assertEquals(expectedDates, category.createdAt());
        Assertions.assertEquals(expectedDates, category.updatedAt());
        Assertions.assertNull(category.deletedAt());
    }

    @Test
    public void givenValidParams_whenCallWithCategory_thenInstantiateACategory() {
        final var expectedId = UUID.randomUUID().toString();
        final var expectedName = "Filmes";
        final var expectedDescription = "Category most viewed";
        final var expectedIsActive = true;
        final var expectedDates = InstantUtils.now();

        final var categoryOrigin = Category.with(expectedId, expectedName, expectedDescription, expectedIsActive, expectedDates, expectedDates, null);

        final var category = Category.with(categoryOrigin);

        Assertions.assertNotNull(category);
        Assertions.assertEquals(expectedId, category.id());
        Assertions.assertEquals(expectedName, category.name());
        Assertions.assertEquals(expectedDescription, category.description());
        Assertions.assertTrue(expectedIsActive);
        Assertions.assertEquals(expectedDates, category.createdAt());
        Assertions.assertEquals(expectedDates, category.updatedAt());
        Assertions.assertNull(category.deletedAt());
    }

    @Test
    public void givenAnInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final var expectedId = UUID.randomUUID().toString();
        final var expectedDescription = "Category most viewed";
        final var expectedIsActive = true;
        final var expectedDates = InstantUtils.now();
        final var expectedErrorCount = 1;
        final var expectedMessage = "'name' should not be null";

        final var category = Category.with(expectedId, null, expectedDescription, expectedIsActive, expectedDates, expectedDates, null);

        final var error = Assertions.assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        Assertions.assertEquals(expectedErrorCount, error.getErrors().size());
        Assertions.assertEquals(expectedMessage, error.getMessage());

    }

    @Test
    public void givenAnEmptyName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final var expectedId = UUID.randomUUID().toString();
        final String expectedName = "";
        final var expectedDescription = "Category most viewed";
        final var expectedIsActive = true;
        final var expectedDates = InstantUtils.now();
        final var expectedErrorCount = 1;
        final var expectedMessage = "'name' should not be null";

        final var category = Category.with(expectedId, expectedName, expectedDescription, expectedIsActive, expectedDates, expectedDates, null);

        final var error = Assertions.assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        Assertions.assertEquals(expectedErrorCount, error.getErrors().size());
        Assertions.assertEquals(expectedMessage, error.getMessage());
    }

    @Test
    public void givenANullId_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final var expectedName = "Filmes";
        final var expectedDescription = "Category most viewed";
        final var expectedIsActive = true;
        final var expectedDates = InstantUtils.now();
        final var expectedErrorCount = 1;
        final var expectedMessage = "'id' should not be null";

        final var category = Category.with(null, expectedName, expectedDescription, expectedIsActive, expectedDates, expectedDates, null);

        final var error = Assertions.assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        Assertions.assertEquals(expectedErrorCount, error.getErrors().size());
        Assertions.assertEquals(expectedMessage, error.getMessage());
    }

    @Test
    public void givenAnEmptyId_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final String expectedId = " ";
        final var expectedName = "Filmes";
        final var expectedDescription = "Category most viewed";
        final var expectedIsActive = true;
        final var expectedDates = InstantUtils.now();
        final var expectedErrorCount = 1;
        final var expectedMessage = "'id' should not be null";

        final var category = Category.with(expectedId, expectedName, expectedDescription, expectedIsActive, expectedDates, expectedDates, null);

        final var error = Assertions.assertThrows(DomainException.class, () -> category.validate(new ThrowsValidationHandler()));
        Assertions.assertEquals(expectedErrorCount, error.getErrors().size());
        Assertions.assertEquals(expectedMessage, error.getMessage());
    }
}

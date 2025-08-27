package com.bookstore.catalog.domain;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var book = new Book("1234567890", "Title", "Author", 10000L);
        var v = validator.validate(book);
        assertThat(v).isEmpty();
    }

    @Test
    void whenIsbnUndefinedThenValidationFails() {
        var book = new Book("", "Title", "Author", 10000L);
        var v = validator.validate(book);
        assertThat(v).anyMatch(e -> e.getPropertyPath().toString().equals("isbn"));
    }

    @Test
    void whenIsbnInvalidThenValidationFails() {
        var book = new Book("123456789", "Title", "Author", 10000L);
        var v = validator.validate(book);
        assertThat(v).anyMatch(e -> e.getPropertyPath().toString().equals("isbn"));
    }

    @Test
    void whenTitleUndefinedThenValidationFails() {
        var book = new Book("1234567890", "", "Author", 10000L);
        var v = validator.validate(book);
        assertThat(v).anyMatch(e -> e.getPropertyPath().toString().equals("title"));
    }

    @Test
    void whenAuthorUndefinedThenValidationFails() {
        var book = new Book("1234567890", "Title", "", 10000L);
        var v = validator.validate(book);
        assertThat(v).anyMatch(e -> e.getPropertyPath().toString().equals("author"));
    }

    @Test
    void whenPriceUndefinedThenValidationFails() {
        var book = new Book("1234567890", "Title", "Author",null);
        var v = validator.validate(book);
        assertThat(v).anyMatch(e -> e.getPropertyPath().toString().equals("price"));
    }

    @Test
    void whenPriceOverMaxThenValidationFails() {
        var book = new Book("1234567890", "Title", "Author",10_000_000_001L);
        var v = validator.validate(book);
        assertThat(v).anyMatch(e -> e.getPropertyPath().toString().equals("price"));
    }
}

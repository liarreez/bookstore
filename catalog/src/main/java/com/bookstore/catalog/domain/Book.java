package com.bookstore.catalog.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book(

        @NotBlank(message = "ISBN은 반드시 있어야 합니다")
        @Pattern(
                regexp = "^(\\d{10}|\\d{13})$",
                message = "ISBN은 10자리 혹은 13자리의 숫자여야 합니다"
        )
        String isbn,
        @NotBlank(message = "제목은 반드시 있어야 합니다")
        String title,
        @NotBlank(message = "저자는 반드시 있어야 합니다")
        String author,
        @NotNull(message = "가격은 반드시 있어야 합니다")
        @Positive(message = "가격은 0보다 커야 합니다")
        double price
) {}

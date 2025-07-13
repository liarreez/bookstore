package com.bookstore.catalog.domain;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("ISBN이 " + isbn + "인 책이 존재하지 않습니다.");
    }
}

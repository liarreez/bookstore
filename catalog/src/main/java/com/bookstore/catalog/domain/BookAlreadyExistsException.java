package com.bookstore.catalog.domain;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String isbn) {
        super("ISBN이 " + isbn + "인 책이 이미 존재합니다");
    }
}

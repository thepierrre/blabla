package com.piotr.postgresdatabase;

import com.piotr.postgresdatabase.domain.Author;
import com.piotr.postgresdatabase.domain.Book;

public final class TestDataUtil {
    private TestDataUtil() {}

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Thomas Cronin")
                .age(44)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Jesse A. Casey")
                .age(24)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("978-1-3434-4333-0")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("978-1-3434-4333-1")
                .title("Hunger Games")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("978-1-3434-4333-2")
                .title("The Witcher")
                .authorId(1L)
                .build();
    }
}

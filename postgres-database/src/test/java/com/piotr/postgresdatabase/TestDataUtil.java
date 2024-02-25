package com.piotr.postgresdatabase;

import com.piotr.postgresdatabase.domain.Author;
import com.piotr.postgresdatabase.domain.Book;

public final class TestDataUtil {
    private TestDataUtil() {}

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("978-1-3434-4333-0")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }
}

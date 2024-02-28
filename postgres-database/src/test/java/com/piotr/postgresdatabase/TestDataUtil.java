package com.piotr.postgresdatabase;

import com.piotr.postgresdatabase.domain.dto.AuthorDto;
import com.piotr.postgresdatabase.domain.dto.BookDto;
import com.piotr.postgresdatabase.domain.entities.AuthorEntity;
import com.piotr.postgresdatabase.domain.entities.BookEntity;

public final class TestDataUtil {
    private TestDataUtil() {}

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Thomas Cronin")
                .age(44)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Jesse A. Casey")
                .age(24)
                .build();
    }

    public static BookEntity createTestBookA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-3434-4333-0")
                .title("The Shadow in the Attic")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto author) {
        return BookDto.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-3434-4333-1")
                .title("Hunger Games")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-3434-4333-2")
                .title("The Witcher")
                .authorEntity(authorEntity)
                .build();
    }
}

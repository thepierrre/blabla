package com.piotr.postgresdatabase.services;

import com.piotr.postgresdatabase.domain.entities.BookEntity;
import org.hibernate.query.Page;

import java.awt.print.Book;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookService {
    BookEntity createUpdateBook(String isbn, BookEntity bookEntity);

    List<BookEntity> findAll();

    Page<BookEntity> findAll(Pageable pageable);

    Optional<BookEntity> findOne(String isbn);

    boolean isExists(String isbn);

    BookEntity partialUpdate(String isbn, BookEntity bookEntity);

    void delete(String isbn);
}

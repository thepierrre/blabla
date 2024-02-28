package com.piotr.postgresdatabase.services.impl;

import com.piotr.postgresdatabase.domain.entities.BookEntity;
import com.piotr.postgresdatabase.repositories.BookRepository;
import com.piotr.postgresdatabase.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> findAll() {
        return StreamSupport
                .stream(bookRepository.findAll().spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookEntity> findOne(String isbn) {
       return bookRepository.findById(isbn);
    }
}

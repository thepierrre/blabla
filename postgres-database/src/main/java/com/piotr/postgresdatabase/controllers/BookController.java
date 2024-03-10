package com.piotr.postgresdatabase.controllers;

import com.piotr.postgresdatabase.domain.dto.BookDto;
import com.piotr.postgresdatabase.domain.entities.BookEntity;
import com.piotr.postgresdatabase.mappers.Mapper;
import com.piotr.postgresdatabase.services.BookService;
import org.hibernate.query.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private BookService bookService;

    private Mapper<BookEntity, BookDto> bookMapper;

    public BookController(BookService bookService, Mapper<BookEntity, BookDto> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> createUpdateBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto) {

        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        boolean bookExists = bookService.isExists(isbn);
        BookEntity savedBookEntity = bookService.createUpdateBook(isbn, bookEntity);
        BookDto savedBookDto = bookMapper.mapTo(savedBookEntity);

        if (bookExists) {
            // update
            return new ResponseEntity<>(savedBookDto, HttpStatus.OK);
        } else {
            // create
            return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);
        }
    }

    @PatchMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> partialUpdateBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto
    ) {
        boolean bookExists = bookService.isExists(isbn);
        if (!bookExists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity updatedBookEntity = bookService.partialUpdate(isbn, bookEntity);
        return new ResponseEntity<>(
                bookMapper.mapTo(updatedBookEntity),
                HttpStatus.OK
        );
    }


//    @GetMapping(path = "/books")
////    public List<BookDto> listBooks() {
////    List<BookEntity> books = bookService.findAll();
////        return books.stream()
////                .map(bookMapper::mapTo)
////                .collect(Collectors.toList());
//    public Page<BookDto> listBooks(Pageable pageable) {
//        Page<BookEntity> books = bookService.findAll(pageable);
//        return books.map(bookMapper::mapTo);
//    }

    @GetMapping(path = "/books")
    public List<BookDto> listBooks() {
        List<BookEntity> books = bookService.findAll();
        return books.stream()
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn) {
        Optional<BookEntity> foundBook = bookService.findOne(isbn);
        return foundBook.map(bookEntity -> {
           BookDto bookDto = bookMapper.mapTo(bookEntity);
           return new ResponseEntity<>(bookDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "/books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable("isbn") String isbn) {
        bookService.delete(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

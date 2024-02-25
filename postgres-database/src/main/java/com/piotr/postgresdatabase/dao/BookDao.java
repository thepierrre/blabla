package com.piotr.postgresdatabase.dao;


import com.piotr.postgresdatabase.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}

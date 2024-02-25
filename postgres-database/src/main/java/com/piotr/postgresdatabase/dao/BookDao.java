package com.piotr.postgresdatabase.dao;


import com.piotr.postgresdatabase.domain.Book;

import java.util.Optional;
import java.util.List;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();
}

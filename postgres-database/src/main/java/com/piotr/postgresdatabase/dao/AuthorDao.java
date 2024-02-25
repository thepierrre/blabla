package com.piotr.postgresdatabase.dao;

import java.util.List;
import java.util.Optional;
import com.piotr.postgresdatabase.domain.Author;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);

    List<Author> find();


}

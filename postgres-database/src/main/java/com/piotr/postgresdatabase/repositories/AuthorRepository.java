package com.piotr.postgresdatabase.repositories;

import com.piotr.postgresdatabase.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // bean that can be injected anywhere it's needed; you don't have to implement the interface
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Iterable<Author> ageLessThan(int age);
}

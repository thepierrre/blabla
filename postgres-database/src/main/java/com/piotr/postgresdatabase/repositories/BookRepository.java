package com.piotr.postgresdatabase.repositories;

import com.piotr.postgresdatabase.domain.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {


}

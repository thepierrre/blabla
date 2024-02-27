package com.piotr.postgresdatabase.services;

import com.piotr.postgresdatabase.domain.entities.AuthorEntity;

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);
}

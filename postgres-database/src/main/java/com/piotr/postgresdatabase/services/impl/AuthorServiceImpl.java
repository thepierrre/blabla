package com.piotr.postgresdatabase.services.impl;

import com.piotr.postgresdatabase.domain.entities.AuthorEntity;
import com.piotr.postgresdatabase.repositories.AuthorRepository;
import com.piotr.postgresdatabase.services.AuthorService;
import org.springframework.stereotype.Service;

// The @Service annotation makes the class a @Bean
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}

// The service layer just does the pass-through (?)

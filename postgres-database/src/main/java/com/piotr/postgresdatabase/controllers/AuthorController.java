package com.piotr.postgresdatabase.controllers;

import com.piotr.postgresdatabase.domain.dto.AuthorDto;
import com.piotr.postgresdatabase.domain.entities.AuthorEntity;
import com.piotr.postgresdatabase.mappers.Mapper;
import com.piotr.postgresdatabase.services.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// presentation layer

@RestController
public class AuthorController {

    private AuthorService authorService;

    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
        this.authorService  = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public AuthorDto createAuthor(@RequestBody AuthorDto author) {
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.createAuthor(authorEntity);
        return authorMapper.mapTo(savedAuthorEntity);
    }
}

package com.piotr.postgresdatabase.controllers;

import com.piotr.postgresdatabase.domain.Author;
import com.piotr.postgresdatabase.services.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService  = authorService;
    }

    @PostMapping(path = "/authors")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }
}

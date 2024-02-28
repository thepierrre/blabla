package com.piotr.postgresdatabase.mappers.impl;

import com.piotr.postgresdatabase.domain.dto.AuthorDto;
import com.piotr.postgresdatabase.domain.entities.AuthorEntity;
import com.piotr.postgresdatabase.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

// the @Component annotation makes the class a @Bean
@Component
public class AuthorMapper implements Mapper<AuthorEntity, AuthorDto> {

    private ModelMapper modelMapper;

    public AuthorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDto.class); // map authorEntity to the AuthorDto class
    }

    @Override
    public AuthorEntity mapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class); // map authorDto to the AuthorEntity class
    }
}

// The first one is without ".class" bc it's an actual instance, not the class itself
// The second one has ".class" bc right now the instance doesn't exist, it will be created from the class

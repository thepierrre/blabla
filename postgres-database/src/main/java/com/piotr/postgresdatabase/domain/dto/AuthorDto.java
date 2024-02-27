package com.piotr.postgresdatabase.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// AuthorDto is a plain old Java object (POJO) - class definition that is not tied to any framework

// AuthorDto should have the same elements as Author
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    private Long id;

    private String name;

    private Integer age;


}

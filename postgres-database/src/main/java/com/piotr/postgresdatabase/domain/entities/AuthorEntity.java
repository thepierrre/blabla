package com.piotr.postgresdatabase.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // labels the object as an entity that can be used with Spring Data JPA
@Table(name = "authors") // the table it maps to in the DB
public class AuthorEntity {

    @Id // the id identifier in the DB
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq") // value generated automatically
    private Long id;
    private String name;
    private Integer age;



}

// The @Entity should be present in our persistence layer and service layer but go no further than that
// Bc we don't want our presentation layer to have any knowledge of how our persistence layer knows.
// One way of dealing with this is using the DTO (data transfer object):
// So the service layer will still return our @Entity, but in the presentation layer we would map that into the DTO
// and the DTO will be the thing that we send.
// So this decouples our presentation layer from our business logic and the persistence layer
// bc we have that mapping layer in between.

// the ModelMapper library helps us convert from DTOs to Entities (so from one class to the other).
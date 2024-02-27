package com.piotr.postgresdatabase.domain;

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
public class Author {

    @Id // the id identifier in the DB
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq") // value generated automatically
    private Long id;
    private String name;
    private Integer age;



}

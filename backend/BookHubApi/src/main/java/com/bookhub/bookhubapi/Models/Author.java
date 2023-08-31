package com.bookhub.bookhubapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String firstNameAuthor;
    private String lastNameAuthor;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

}

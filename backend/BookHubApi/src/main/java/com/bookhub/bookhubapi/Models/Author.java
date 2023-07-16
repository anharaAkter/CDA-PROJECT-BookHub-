package com.bookhub.bookhubapi.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String firstNameAuthor;
    private String lastNameAuthor;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}

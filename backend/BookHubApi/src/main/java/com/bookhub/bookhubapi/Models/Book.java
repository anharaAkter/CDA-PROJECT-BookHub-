package com.bookhub.bookhubapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String title;
    private String description;
    private boolean status;
    private Date publishDate;
    private int copiesOwned;

    @ManyToOne
    @JoinColumn(name = "category_id",insertable = true,updatable = true,referencedColumnName = "categoryId")
    @JsonIgnore
    private Category category;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name="book_authors",joinColumns=@JoinColumn(name = "book_id"),
    inverseJoinColumns= @JoinColumn(name="author_id"))
    private Set<Author> authors = new HashSet<>();

}

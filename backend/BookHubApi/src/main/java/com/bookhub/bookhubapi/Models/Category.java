package com.bookhub.bookhubapi.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Category {
    @Id
    private int categoryId;
    private String nameCategory;

    @OneToMany(mappedBy = "category")
    private List<Book> books;


}

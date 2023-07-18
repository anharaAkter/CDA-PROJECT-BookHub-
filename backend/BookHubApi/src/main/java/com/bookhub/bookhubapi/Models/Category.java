package com.bookhub.bookhubapi.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category {
    @Id
    private int categoryId;
    private String nameCategory;


}

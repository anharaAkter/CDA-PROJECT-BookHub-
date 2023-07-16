package com.bookhub.bookhubapi.Repositories;

import com.bookhub.bookhubapi.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}

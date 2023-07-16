package com.bookhub.bookhubapi.Repositories;

import com.bookhub.bookhubapi.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
}

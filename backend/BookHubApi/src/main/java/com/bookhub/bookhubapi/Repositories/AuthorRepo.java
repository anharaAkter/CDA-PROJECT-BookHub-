package com.bookhub.bookhubapi.Repositories;

import com.bookhub.bookhubapi.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {
}

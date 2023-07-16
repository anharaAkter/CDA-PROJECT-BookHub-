package com.bookhub.bookhubapi.Services;

import com.bookhub.bookhubapi.Models.Author;
import com.bookhub.bookhubapi.Repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    public List<Author> getAllAuthor(){
        return authorRepo.findAll();
    }

    public void addAuthor(Author author) {
        authorRepo.save(author);
    }
}

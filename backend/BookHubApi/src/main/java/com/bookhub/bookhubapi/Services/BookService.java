package com.bookhub.bookhubapi.Services;

import com.bookhub.bookhubapi.Models.Book;
import com.bookhub.bookhubapi.Repositories.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }


 /*   public Optional<Book> getBookById(int id) {
        return bookRepo.findById(id);
    }*/

    public void addBook(Book book) {
        bookRepo.save(book);
    }
}

package com.bookhub.bookhubapi.Services;

import com.bookhub.bookhubapi.Models.Book;
import com.bookhub.bookhubapi.Models.Category;
import com.bookhub.bookhubapi.Repositories.BookRepo;

import com.bookhub.bookhubapi.Repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }


 /*   public Optional<Book> getBookById(int id) {
        return bookRepo.findById(id);
    }*/

   /* public void addBook(Book book) {
        bookRepo.save(book);
    }*/

    public Optional<Book> getBookById(int id) {
        return bookRepo.findById(id);
    }

    public Book addBook(Book book, int categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Not found category with id = " + categoryId));

        book.setCategory(category);
        return bookRepo.save(book);
    }
}

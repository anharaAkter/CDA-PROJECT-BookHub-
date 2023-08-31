package com.bookhub.bookhubapi.Services;

import com.bookhub.bookhubapi.Models.Author;
import com.bookhub.bookhubapi.Models.Book;
import com.bookhub.bookhubapi.Models.Category;
import com.bookhub.bookhubapi.Repositories.AuthorRepo;
import com.bookhub.bookhubapi.Repositories.BookRepo;

import com.bookhub.bookhubapi.Repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;


@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private AuthorRepo authorRepo;

    public Book getAllBookByAuthorId(int bookId, int authorId) {

        Set<Author> authorSet = null;
        Book book = bookRepo.findById(bookId).get();
        Author author = authorRepo.findById(authorId).get();
        authorSet =  book.getAuthors();
        authorSet.add(author);
        book.setAuthors(authorSet);
        return bookRepo.save(book);
    }

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

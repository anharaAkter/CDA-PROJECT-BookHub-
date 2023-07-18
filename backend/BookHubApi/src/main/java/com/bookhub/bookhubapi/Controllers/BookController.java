package com.bookhub.bookhubapi.Controllers;

import com.bookhub.bookhubapi.Models.Book;
import com.bookhub.bookhubapi.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }


    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id).orElseThrow();
    }

/*    @PostMapping("/book")
    public void addBook(@RequestBody  Book book){
        bookService.addBook(book);
    }*/

    //PostMapping book with category
    @PostMapping("book/{id}")
    public Book addBookWithCategory(@RequestParam Integer categoryId, @RequestBody Book book) {
        return bookService.saveBookWithCategory(categoryId, book);
    }
}

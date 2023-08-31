package com.bookhub.bookhubapi.Controllers;

import com.bookhub.bookhubapi.Models.Author;
import com.bookhub.bookhubapi.Models.Book;
import com.bookhub.bookhubapi.Services.AuthorService;
import com.bookhub.bookhubapi.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }


    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id).orElseThrow();
    }



    //assign book id to authorid for the related bookq
    @PutMapping("/{bookId}/author/{authorId}")
    public Book getAllBookByAuthorId(
            @PathVariable int bookId,
            @PathVariable int authorId
    ){
        return bookService.getAllBookByAuthorId(bookId, authorId);
    }

    @PostMapping("/category/{categoryId}/books")
    public Book addBook(@PathVariable(value = "categoryId") int categoryId,
                        @RequestBody Book bookRequest){
        return bookService.addBook(bookRequest, categoryId);
    }
}

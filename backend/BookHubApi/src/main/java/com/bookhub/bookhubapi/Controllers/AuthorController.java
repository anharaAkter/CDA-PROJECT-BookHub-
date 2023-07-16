package com.bookhub.bookhubapi.Controllers;

import com.bookhub.bookhubapi.Models.Author;
import com.bookhub.bookhubapi.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable(value = "id") Integer id){
        return authorService.getAuthorById(id);
    }
    @PostMapping("/author")
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    @PostMapping("author/{id}")
    public Author updateAuthor(@PathVariable("id") Integer id , @RequestBody Author author){
        return authorService.updateAuthor(author,id);
    }
}

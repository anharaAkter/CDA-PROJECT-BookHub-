package com.bookhub.bookhubapi.Controllers;

import com.bookhub.bookhubapi.Models.Author;
import com.bookhub.bookhubapi.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }
    @PostMapping("/author")
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }
}

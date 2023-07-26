package com.bookhub.bookhubapi.Services;

import com.bookhub.bookhubapi.Models.Author;
import com.bookhub.bookhubapi.Repositories.AuthorRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    public List<Author> getAllAuthor(){
        return authorRepo.findAll();
    }

    public Author getAuthorById(Integer id){
        return authorRepo.findById(id).orElseThrow();
    }
    public Author updateAuthor(Author author, int id) {
        // Check if the provided Author object is valid
        if (author == null || author.getFirstNameAuthor() == null || author.getLastNameAuthor() == null) {
            throw new IllegalArgumentException("Invalid Author data. All fields are required.");
        }

        // Find the existing author by id
        Author existingAuthor = authorRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Author with id " + id + " not found."));

        // Update the existing author with the values from the input author
        existingAuthor.setAuthorId(author.getAuthorId());
        existingAuthor.setFirstNameAuthor(author.getFirstNameAuthor());
        existingAuthor.setLastNameAuthor(author.getLastNameAuthor());

        // Save the updated author to the database
        existingAuthor = authorRepo.save(existingAuthor);

        return existingAuthor;
    }


    public void addAuthor(Author author) {
        authorRepo.save(author);
    }


        public void deleteAuthor(Integer id){
            authorRepo.findById(id).orElseThrow();
            authorRepo.deleteById(id);
        }
}

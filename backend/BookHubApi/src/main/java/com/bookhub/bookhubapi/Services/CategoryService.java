package com.bookhub.bookhubapi.Services;

import com.bookhub.bookhubapi.Models.Author;
import com.bookhub.bookhubapi.Models.Category;
import com.bookhub.bookhubapi.Repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public Category getCategoryById(Integer id) {
        return categoryRepo.findById(id).orElseThrow();
    }

    public Category updateCategory(Category category, Integer id) {
        // Check if the provided category object is valid
        if (category == null  || category.getNameCategory() == null) {
            throw new IllegalArgumentException("Invalid Author data. All fields are required.");
        }
        // Find the existing category by id
        Category existingCategory = categoryRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Author with id " + id + " not found."));

         // Update the existing category with the values from the input category
        existingCategory.setCategoryId(category.getCategoryId());
        existingCategory.setNameCategory(category.getNameCategory());

        // Save the updated category to the database
        existingCategory = categoryRepo.save(existingCategory);

        return existingCategory;
    }

    public void deleteCategory(Integer id) {
        categoryRepo.findById(id).orElseThrow();
        categoryRepo.deleteById(id);
    }
}

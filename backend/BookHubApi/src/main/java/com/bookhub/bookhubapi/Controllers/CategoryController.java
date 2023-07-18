package com.bookhub.bookhubapi.Controllers;
import com.bookhub.bookhubapi.Models.Category;

import com.bookhub.bookhubapi.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/category/")
    public void addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }
    @GetMapping("/categories")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Integer id){
        return categoryService.getCategoryById(id);
    }

    //update category
    @PostMapping("category/{id}")
    public Category updateCategory(@PathVariable("id") Integer id , @RequestBody Category category){
        return categoryService.updateCategory(category,id);
    }

    //delete category
    @DeleteMapping("category/{id}")
    public void deleteCategory(@PathVariable("id") Integer id){
        categoryService.deleteCategory(id);
    }







}

package com.khay.ecommerce.controllers;

import com.khay.ecommerce.domain.Category.Category;
import com.khay.ecommerce.services.CategoryServices.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryResource {

    private CategoryService service;

    @Autowired
    public CategoryResource(CategoryService service) {
        this.service = service;
    }
    @CrossOrigin
    @GetMapping("/category")
    public Iterable<Category> getAllCategories(){
        return service.getAllCategories();
    }
    @CrossOrigin
    @GetMapping("/category/{id}")
    public Category getCategories(@PathVariable int id){
        return service.getCategory(id);
    }
    @PostMapping("/category")
    public Category saveNewCategory(@RequestBody Category category){
        return service.saveCategory(category);
    }
    @DeleteMapping("/category/{id}")
    public Category deleteCategory(@PathVariable int id){
        return service.deleteCategoryById(id);
    }
}

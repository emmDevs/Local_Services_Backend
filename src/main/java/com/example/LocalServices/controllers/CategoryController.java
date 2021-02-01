package com.example.LocalServices.controllers;

import com.example.LocalServices.models.Category;
import com.example.LocalServices.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
public class CategoryController {

    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void configurePathMatch(PathMatchConfigurer configurer) {
            AntPathMatcher matcher = new AntPathMatcher();
            matcher.setCaseSensitive(false);
            configurer.setPathMatcher(matcher);
        }
    }

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = "/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity(categoryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        return new ResponseEntity(categoryRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> postCategory(@RequestBody Category category){
        categoryRepository.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/categories/{id}")
    public ResponseEntity<Long> deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/categories/{id}")
    public ResponseEntity<Category> updateCatagory(@RequestBody Category category, @PathVariable Long id){
        Category categoryToUpdate = categoryRepository.findById(id).get();
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setDescription(category.getDescription());
        categoryToUpdate.setImage(category.getImage());
        categoryRepository.save(categoryToUpdate);
        return new ResponseEntity<>(categoryToUpdate, HttpStatus.OK);
    }


}

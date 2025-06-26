package com.example.Ecommerce.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    @GetMapping
    public String getCategory(){
        return "Electronics";
    }
    @GetMapping("/count")
    public int getCategoryCount(){
        return 5;
    }
    @DeleteMapping
    public String deleteCategory(){
        return "Category deleted";
    }
}

package com.example.Ecommerce.controllers;

import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.service.FakeStoreCategoryService;
import com.example.Ecommerce.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService _categoryService) {
        this.categoryService = _categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() throws IOException {

        return this.categoryService.getAllCategories();
    }
}

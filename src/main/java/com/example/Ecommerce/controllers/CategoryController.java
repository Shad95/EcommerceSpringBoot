package com.example.Ecommerce.controllers;

import com.example.Ecommerce.dto.AllProductsOfCategoryDTO;
import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.service.FakeStoreCategoryService;
import com.example.Ecommerce.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if(name != null && !name.isBlank()) {
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        }else {
            List<CategoryDTO> result = this.categoryService.getAllCategories();
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO created = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<AllProductsOfCategoryDTO> getAllProductsOfCategory(@PathVariable Long id) throws Exception{

        AllProductsOfCategoryDTO dto = categoryService.getAllProductsOfCategory(id);
        return ResponseEntity.ok(dto);

    }
}

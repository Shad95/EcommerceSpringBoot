package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.AllProductsOfCategoryDTO;
import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.mappers.CategoryMapper;
import com.example.Ecommerce.mappers.GetAllCategoriesMapper;
import com.example.Ecommerce.mappers.ProductMapper;
import com.example.Ecommerce.repository.CategoryRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryService implements ICategoryService{

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> dtos = new ArrayList<>();
        for (Category category : repo.findAll()) {
            dtos.add(CategoryMapper.toDto(category));
        }
        return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category saved = repo.save(category);
        return CategoryMapper.toDto(saved);
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        Category category = repo.findByName(name)
                .orElseThrow(() -> new Exception("Category not found with name: " + name));

        return CategoryMapper.toDto(category);

    }

    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception {
        Category category = repo.findById(categoryId)
                .orElseThrow(() -> new Exception("Category not found with id: " + categoryId));

        List<ProductDTO> productDTOs = category.getProducts()
                .stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());

        return AllProductsOfCategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .products(productDTOs)
                .build();
    }
}

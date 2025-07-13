package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.AllProductsOfCategoryDTO;
import com.example.Ecommerce.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO getByName(String name) throws Exception;
    AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception;
}

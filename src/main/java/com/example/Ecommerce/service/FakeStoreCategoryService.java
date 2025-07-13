package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.AllProductsOfCategoryDTO;
import com.example.Ecommerce.dto.CategoryDTO;
import com.example.Ecommerce.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(
            @Qualifier("fakeStoreRestTemplateGateway")
                    ICategoryGateway categoryGateway) {

        this.categoryGateway = categoryGateway;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        return this.categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }

    public CategoryDTO getByName(String name) throws Exception{
        //Not Implemented
        return null;
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) {
        //Not Implemented
        return null;
    }
}

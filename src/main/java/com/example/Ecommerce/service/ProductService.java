package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.ProductWithCategoryDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.exception.ProductNotFoundException;
import com.example.Ecommerce.mappers.ProductMapper;
import com.example.Ecommerce.repository.CategoryRepository;
import com.example.Ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        /*return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));*/
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product" +
                        " with Id: " + id + " not found"));
         return ProductMapper.toDto(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));
        Product saved = productRepository.save(ProductMapper.toEntity(dto,category));
        return ProductMapper.toDto(saved);
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        return ProductMapper.toProductWithCategoryDTO(product);
    }

}

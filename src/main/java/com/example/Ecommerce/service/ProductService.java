package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.mappers.ProductMapper;
import com.example.Ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        /*return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));*/
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
         return ProductMapper.toDto(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Product saved = productRepository.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDto(saved);
    }
}

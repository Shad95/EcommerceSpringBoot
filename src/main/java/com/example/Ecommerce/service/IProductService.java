package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.entity.Product;

public interface IProductService {
    ProductDTO getProductById(Long id) throws Exception;

    ProductDTO createProduct(ProductDTO dto);
}

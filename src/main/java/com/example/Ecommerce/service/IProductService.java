package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.ProductDTO;

public interface IProductService {
    ProductDTO getProductById(Long id) throws Exception;
}

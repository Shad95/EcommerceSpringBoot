package com.example.Ecommerce.gateway;


import com.example.Ecommerce.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {
    ProductDTO getProductById(Long id) throws Exception;
}

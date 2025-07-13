package com.example.Ecommerce.controllers;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.ProductWithCategoryDTO;
import com.example.Ecommerce.exception.ProductNotFoundException;
import com.example.Ecommerce.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) throws Exception{
            ProductDTO result = this.productService.getProductById(id);
            return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws Exception{
    return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable long id) throws Exception {

        ProductWithCategoryDTO dto =  productService.getProductWithCategory(id);
        return ResponseEntity.ok(dto);
    }


}

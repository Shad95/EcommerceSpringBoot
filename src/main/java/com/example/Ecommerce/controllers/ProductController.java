package com.example.Ecommerce.controllers;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.service.IProductService;
import com.example.Ecommerce.service.ProductService;
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
    public ResponseEntity<ProductDTO> getProductById(@PathVariable long id) throws Exception {
    ProductDTO result = this.productService.getProductById(id);
    return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto){
    return ResponseEntity.ok(productService.createProduct(dto));
    }

}

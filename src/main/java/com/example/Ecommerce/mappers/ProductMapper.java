package com.example.Ecommerce.mappers;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.ProductWithCategoryDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.entity.Product;

public class ProductMapper {
    public static ProductDTO toDto(Product product){
    return ProductDTO.builder()
            .id(product.getId())
            .image(product.getImage())
            .color(product.getColor())
            .price(product.getPrice())
            .description(product.getDescription())
            .discount(product.getDiscount())
            .categoryId(product.getCategory().getId())
            .model(product.getModel())
            .title(product.getTitle())
            .brand(product.getBrand())
            .popular(product.isPopular())
            .build();
    }

    public static Product toEntity(ProductDTO dto, Category category){
        return Product.builder()
                .image(dto.getImage())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .model(dto.getModel())
                .category(category)
                .title(dto.getTitle())
                .brand(dto.getBrand())
                .popular(dto.isPopular())
                .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product) {
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .category(CategoryMapper.toDto(product.getCategory()))
                .build();
    }
}

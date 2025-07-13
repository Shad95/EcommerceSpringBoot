package com.example.Ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}

package com.example.desafio_spring.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {
    private Long productID;
    private String name;
    private String category;
    private String brand;
    private Long price;
    private Long quantity;
    private Boolean freeShipping;
    private String prestige;
}

package com.example.desafio_spring.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Article {
    private UUID productId=UUID.randomUUID();
    private String name;
    private String category;
    private String brand;
    private Double price;
    private Integer quantity;
    private Boolean freeShipping;
    private String prestige;

}

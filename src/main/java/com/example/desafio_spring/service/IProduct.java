package com.example.desafio_spring.service;

import com.example.desafio_spring.model.Product;

import java.util.List;

public interface IProduct {
    List<Product> createNewProduct(Product newProduct);
}

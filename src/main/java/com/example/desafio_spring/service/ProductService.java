package com.example.desafio_spring.service;

import com.example.desafio_spring.model.Product;
import com.example.desafio_spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> createNewProduct(Product newProduct) {
        return productRepository.createNewProduct(newProduct);
    }
}

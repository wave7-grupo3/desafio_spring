package com.example.desafio_spring.controller;

import com.example.desafio_spring.model.Product;
import com.example.desafio_spring.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private IProduct productService;

    @PostMapping("/insert-articles-request")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Product>> createNewProduct(@RequestBody Product newProduct) {
        return new ResponseEntity<>(productService.createNewProduct(newProduct), HttpStatus.CREATED);
    }
}

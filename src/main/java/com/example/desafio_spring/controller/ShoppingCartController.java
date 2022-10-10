package com.example.desafio_spring.controller;

import com.example.desafio_spring.advisor.exception.NotFoundException;
import com.example.desafio_spring.dto.CartDTO;
import com.example.desafio_spring.service.IShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ShoppingCartController {
    @Autowired
    private IShoppingCart shoppingCartService;

    @GetMapping("/shoppingCart")
    public ResponseEntity<CartDTO> getCart() throws NotFoundException {
        return new ResponseEntity<>(shoppingCartService.getCart(), HttpStatus.OK);
    }
}

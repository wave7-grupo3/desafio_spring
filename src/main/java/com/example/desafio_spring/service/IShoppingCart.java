package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.dto.CartDTO;
import com.example.desafio_spring.model.Ticket;

import java.util.List;

public interface IShoppingCart {
    List<Ticket> getAll() throws NotFoundException;
    CartDTO getCart() throws NotFoundException;
}

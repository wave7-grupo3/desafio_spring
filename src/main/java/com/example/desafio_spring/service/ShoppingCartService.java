package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.dto.CartDTO;
import com.example.desafio_spring.model.Ticket;
import com.example.desafio_spring.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService implements IShoppingCart {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public List<Ticket> getAll() throws NotFoundException {
        return shoppingCartRepository.getAll();
    }

    @Override
    public CartDTO getCart() throws NotFoundException {
        List<Ticket> tickets = shoppingCartRepository.getAll();

        Double total = tickets.stream()
                .map(Ticket::getTotal)
                .reduce(0.0, Double::sum);

        return CartDTO.builder()
                .tickets(tickets)
                .total(total)
                .build();
    }
}

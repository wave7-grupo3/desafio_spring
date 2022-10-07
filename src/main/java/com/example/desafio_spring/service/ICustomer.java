package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.model.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> getAll() throws NotFoundException;
}
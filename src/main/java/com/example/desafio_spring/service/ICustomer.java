package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.ConflictException;
import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.model.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> getAll() throws NotFoundException;
    List<Customer> createNewCustomer(Customer newCustomer) throws WriterValueException, NotFoundException, ConflictException;
    List<Customer> getAllByState(String uf) throws NotFoundException;
}

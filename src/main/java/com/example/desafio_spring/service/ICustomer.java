package com.example.desafio_spring.service;

import com.example.desafio_spring.advisor.exception.ConflictException;
import com.example.desafio_spring.advisor.exception.NotFoundException;
import com.example.desafio_spring.advisor.exception.WriterValueException;
import com.example.desafio_spring.model.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> getAll() throws NotFoundException;
    List<Customer> createNewCustomer(Customer newCustomer) throws WriterValueException, NotFoundException, ConflictException;
    List<Customer> getAllByState(String uf) throws NotFoundException;
}

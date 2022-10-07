package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.model.Customer;
import com.example.desafio_spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomer{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() throws NotFoundException {
        return customerRepository.getAll();
    }

    @Override
    public List<Customer> createNewCustomer(Customer newCustomer) throws WriterValueException, NotFoundException {
        return customerRepository.createNewCustomer(newCustomer);
    }

}

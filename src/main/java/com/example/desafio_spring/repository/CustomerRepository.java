package com.example.desafio_spring.repository;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.model.Article;
import com.example.desafio_spring.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository {
    private static final String LINK_FILE = "src/main/resources/customers.json";

    ObjectMapper mapper = new ObjectMapper();
    List<Customer> customerList;

    public List<Customer> getAll() throws NotFoundException {

        try {
            customerList = Arrays.asList(mapper.readValue(new File(LINK_FILE), Customer[].class));
        } catch (Exception ex) {
            throw new NotFoundException("Customer not found!");
        }
        return customerList;
    }
}

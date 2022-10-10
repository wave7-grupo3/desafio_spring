package com.example.desafio_spring.repository;

import com.example.desafio_spring.advisor.exception.NotFoundException;
import com.example.desafio_spring.advisor.exception.WriterValueException;
import com.example.desafio_spring.model.Customer;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
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

    public List<Customer> createNewCustomer(Customer newCustomer) throws WriterValueException, NotFoundException {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        customerList = getAll();

        customerList = new ArrayList<>(customerList);
        customerList.add(newCustomer);

        try {
            writer.writeValue(new File(LINK_FILE), customerList);
        } catch (Exception ex) {
            throw new WriterValueException("The file wasn't written!");
        }
        return customerList;
    }




}

package com.example.desafio_spring.controller;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.model.Customer;
import com.example.desafio_spring.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private ICustomer customerService;

    @GetMapping("/customer-profile")
    public ResponseEntity<List<Customer>> getAll() throws NotFoundException {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/customer-profile")
    public ResponseEntity<List<Customer>> createNewCustomer(@RequestBody Customer newCustomer) throws WriterValueException, NotFoundException {
        return new ResponseEntity<>(customerService.createNewCustomer(newCustomer), HttpStatus.CREATED);
    }
}

package com.example.desafio_spring.controller;

import com.example.desafio_spring.advice.exception.ConflictException;
import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.model.Customer;
import com.example.desafio_spring.service.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(value ="/customer-profile")
    public ResponseEntity<List<Customer>> createNewCustomer(@RequestBody Customer newCustomer) throws WriterValueException, NotFoundException, ConflictException {
        return new ResponseEntity<>(customerService.createNewCustomer(newCustomer), HttpStatus.CREATED);
    }

    @GetMapping(value = "/customer-profile", params= {"uf"})
    public ResponseEntity<List<Customer>> getAllByUf(@RequestParam("uf") String uf) throws NotFoundException {
        return new ResponseEntity<>(customerService.getAllByState(uf), HttpStatus.OK);
    }

}

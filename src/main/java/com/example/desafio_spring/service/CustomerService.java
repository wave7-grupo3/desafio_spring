package com.example.desafio_spring.service;

import com.example.desafio_spring.advisor.exception.ConflictException;
import com.example.desafio_spring.advisor.exception.NotFoundException;
import com.example.desafio_spring.advisor.exception.WriterValueException;
import com.example.desafio_spring.model.Customer;
import com.example.desafio_spring.repository.CustomerRepository;
import com.example.desafio_spring.utils.validateCustomer.ValidateCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService extends ValidateCustomer implements ICustomer {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ValidateCustomer validateCustomer;

    @Override
    public List<Customer> getAll() throws NotFoundException {
        return customerRepository.getAll();
    }

    @Override
    public List<Customer> createNewCustomer(Customer newCustomer) throws WriterValueException, ConflictException, NotFoundException {

        String name = newCustomer.getName();
        String cpf = newCustomer.getCpf();
        String uf = newCustomer.getUf();

//        if(name == null || cpf == null || uf == null || name.isEmpty() || cpf.isEmpty() || uf.isEmpty()) {
//            throw new ConflictException("Invalid fields");
//        }
        validateCustomer.verifyCPF(cpf);
        validateCustomer.verifyName(name);
        validateCustomer.verifyUF(uf);

        List<Customer> customerList = customerRepository.getAll();
        boolean customerExist = customerList.stream().anyMatch((c) -> c.getCpf().equals(newCustomer.getCpf()));

        if(customerExist) {
            throw new ConflictException("Customer already exists!");
        }

        return customerRepository.createNewCustomer(newCustomer);
    }
    @Override
    public List<Customer> getAllByState(String uf) throws NotFoundException {
        List<Customer> customers = customerRepository.getAll();

        List<Customer> filteredCustomer = customers.stream()
                .filter(c -> c.getUf().equalsIgnoreCase(uf))
                .collect(Collectors.toList());

        if(filteredCustomer.isEmpty()) {
            throw new NotFoundException("No results found for the search: " + uf);
        }

        return  filteredCustomer;
    }

}

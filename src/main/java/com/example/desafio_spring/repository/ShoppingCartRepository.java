package com.example.desafio_spring.repository;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.model.Ticket;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ShoppingCartRepository {

    private static final String LINK_FILE = "src/main/resources/shoppingCart.json";
    ObjectMapper mapper = new ObjectMapper();

    List<Ticket> ticketList;

    public List<Ticket> getAll() throws NotFoundException {
        try {
            ticketList = Arrays.asList(mapper.readValue(new File(LINK_FILE), Ticket[].class));
        } catch(Exception ex) {
            throw new NotFoundException("Tickets not found!");
        }
        return ticketList;
    }

    public void save(Ticket ticket) throws NotFoundException, WriterValueException {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        ticketList = getAll();

        ticketList = new ArrayList<>(ticketList);
        ticketList.add(ticket);

        try {
            writer.writeValue(new File(LINK_FILE), ticketList);
        } catch (Exception ex) {
            throw new WriterValueException("The file wasn't written!");
        }

    }
}


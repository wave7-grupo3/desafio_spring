package com.example.desafio_spring.repository;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.dto.ArticleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class PurchaseRepository {
    private static final String LINK_FILE = "src/main/resources/articlesPurchaseRequest.json";
    ObjectMapper mapper = new ObjectMapper();
    List<ArticleDTO> purchasesList;

    public List<ArticleDTO> getAllPurchases() throws NotFoundException {
        try {
            purchasesList = Arrays.asList(mapper.readValue(new File(LINK_FILE), ArticleDTO[].class));
        } catch (Exception ex) {
            throw new NotFoundException("Purchase not found!");
        }
        return purchasesList;
    }

}

package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.dto.ArticleDTO;
import com.example.desafio_spring.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService implements IPurchase {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<ArticleDTO> getAllPurchases() throws NotFoundException {
        return purchaseRepository.getAllPurchases();
    }
}

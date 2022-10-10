package com.example.desafio_spring.service;

import com.example.desafio_spring.advisor.exception.NotFoundException;
import com.example.desafio_spring.advisor.exception.WriterValueException;
import com.example.desafio_spring.dto.ArticleDTO;
import com.example.desafio_spring.dto.PurchaseDTO;

import java.util.List;

public interface IPurchase {
    List<ArticleDTO> getAllPurchases() throws NotFoundException;
    PurchaseDTO createNewPurchase(List<ArticleDTO> newPurchase) throws NotFoundException, WriterValueException;
}

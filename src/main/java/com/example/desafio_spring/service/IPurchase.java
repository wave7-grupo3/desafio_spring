package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.dto.ArticleDTO;
import com.example.desafio_spring.dto.PurchaseDTO;
import com.example.desafio_spring.model.Article;

import java.util.List;

public interface IPurchase {
    List<ArticleDTO> getAllPurchases() throws NotFoundException;
    PurchaseDTO createNewPurchase(List<ArticleDTO> newPurchase) throws NotFoundException, WriterValueException;
}

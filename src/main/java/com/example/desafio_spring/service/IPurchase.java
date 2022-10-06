package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.dto.ArticleDTO;

import java.util.List;

public interface IPurchase {
    List<ArticleDTO> getAllPurchases() throws NotFoundException;
}

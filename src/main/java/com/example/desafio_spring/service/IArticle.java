package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.dto.ArticleDTO;
import com.example.desafio_spring.model.Article;

import java.util.List;

public interface IArticle {
    List<ArticleDTO> createNewArticle(Article newArticle) throws NotFoundException;
}

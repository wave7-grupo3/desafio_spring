package com.example.desafio_spring.service;

import com.example.desafio_spring.advisor.exception.NotFoundException;
import com.example.desafio_spring.advisor.exception.WriterValueException;
import com.example.desafio_spring.dto.ArticleDTO;
import com.example.desafio_spring.model.Article;

import java.util.List;

public interface IArticle {
    List<ArticleDTO> createNewArticle(Article newArticle) throws NotFoundException, WriterValueException;
    List<Article> getAll() throws NotFoundException;
    List<Article> getAllByCategory(String category) throws NotFoundException;
    List<Article> getAllByShipping(List<Article> articles, boolean freeShipping) throws NotFoundException;
    List<Article> getAllByPrestige(String prestige) throws NotFoundException;
    List<Article> getAllSorted(List<Article> article, int order) throws NotFoundException;
}
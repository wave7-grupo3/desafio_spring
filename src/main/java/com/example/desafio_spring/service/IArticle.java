package com.example.desafio_spring.service;

import com.example.desafio_spring.model.Article;

import java.util.List;

public interface IArticle {
    List<Article> createNewArticle(Article newArticle);
}

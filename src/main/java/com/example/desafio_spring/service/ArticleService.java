package com.example.desafio_spring.service;

import com.example.desafio_spring.model.Article;
import com.example.desafio_spring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticle {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> createNewArticle(Article newArticle) {
        return articleRepository.createNewArticle(newArticle);
    }
}

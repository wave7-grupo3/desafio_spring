package com.example.desafio_spring.service;

import com.example.desafio_spring.dto.ArticleDTO;
import com.example.desafio_spring.model.Article;
import com.example.desafio_spring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService implements IArticle {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleDTO> createNewArticle(Article newArticle) {
        List<Article> articlesList = articleRepository.createNewArticle(newArticle);
        return articlesList.stream()
                .map(ArticleDTO::new)
                .collect(Collectors.toList());
    }
}

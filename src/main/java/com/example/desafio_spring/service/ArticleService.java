package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
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
    public List<ArticleDTO> createNewArticle(Article newArticle) throws NotFoundException, WriterValueException {
        List<Article> articlesList = articleRepository.createNewArticle(newArticle);
        return articlesList.stream()
                .map(ArticleDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> getAll() throws NotFoundException {
        return articleRepository.getAll();
    }

    @Override
    public List<Article> getAllByCategory(String category) throws NotFoundException {
        List<Article> articles = articleRepository.getAllByCategory(category);

        if (articles.isEmpty()) {
            throw new NotFoundException("Filter with this category not found!");
        }

        return articles;
    }

    @Override
    public List<Article> getAllByShipping(List<Article> articles, boolean freeShipping) throws NotFoundException {
        List<Article> articleList = articleRepository.getAllByShipping(articles, freeShipping);

        if (articleList.isEmpty()) {
            throw new NotFoundException("Filter with this free shipping not found!");
        }

        return articleList;
    }

    @Override
    public List<Article> getAllByPrestige(String prestige) throws NotFoundException {
        List<Article> articles = articleRepository.getAllByPrestige(prestige);

        if (articles.isEmpty()) {
            throw new NotFoundException("Filter with this prestige not found!");
        }

        return articles;
    }

}

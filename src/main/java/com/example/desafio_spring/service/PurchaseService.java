package com.example.desafio_spring.service;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.dto.ArticleDTO;
import com.example.desafio_spring.dto.PurchaseDTO;
import com.example.desafio_spring.model.Article;
import com.example.desafio_spring.model.Ticket;
import com.example.desafio_spring.repository.ArticleRepository;
import com.example.desafio_spring.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService implements IPurchase {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public List<ArticleDTO> getAllPurchases() throws NotFoundException {
        return purchaseRepository.getAllPurchases();
    }

    @Override
    public List<Article> createNewPurchase(List<ArticleDTO> newPurchase) throws NotFoundException {
        List<Article> articleList = articleRepository.getAll();
        List<Article> filteredArticle = new ArrayList<>();

        newPurchase.stream()
                .forEach(purchase -> {
                    List<Article> article = articleList.stream()
                            .filter(art -> art.getProductId() == purchase.getProductId())
                            .collect(Collectors.toList());
                    filteredArticle.addAll(article);
                });

        return filteredArticle;
    }
}

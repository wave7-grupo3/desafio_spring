package com.example.desafio_spring.controller;

import com.example.desafio_spring.model.Article;
import com.example.desafio_spring.service.IArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArticleController {

    @Autowired
    private IArticle articleService;

    @PostMapping("/insert-articles-request")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Article>> createNewArticle(@RequestBody Article newArticle) {
        return new ResponseEntity<>(articleService.createNewArticle(newArticle), HttpStatus.CREATED);
    }
}

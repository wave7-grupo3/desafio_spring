package com.example.desafio_spring.controller;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.dto.ArticleDTO;
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
    public ResponseEntity<List<ArticleDTO>> createNewArticle(@RequestBody Article newArticle) throws NotFoundException, WriterValueException {
        return new ResponseEntity<>(articleService.createNewArticle(newArticle), HttpStatus.CREATED);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAll() throws NotFoundException {
        return new ResponseEntity<>(articleService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/articles/")
    public ResponseEntity<List<Article>> getAllByCategory(@RequestParam String category) throws NotFoundException {
        return new ResponseEntity<>(articleService.getAllByCategory(category), HttpStatus.OK);
    }
}

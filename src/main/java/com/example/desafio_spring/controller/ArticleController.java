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

import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping(value = "/articles")
    public ResponseEntity<List<Article>> getAll() throws NotFoundException {
        return new ResponseEntity<>(articleService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/articles", params= {"category"})
    public ResponseEntity<List<Article>> getAllByCategory(@RequestParam("category") String category) throws NotFoundException {
        return new ResponseEntity<>(articleService.getAllByCategory(category), HttpStatus.OK);
    }

    @GetMapping(value = "/articles", params= {"category", "freeShipping"})
    public ResponseEntity<List<Article>> getAllByFilters(
            @RequestParam("category") String category,
            @RequestParam("freeShipping") boolean freeShipping) throws NotFoundException {
        List<Article> articles = articleService.getAllByCategory(category);
        return new ResponseEntity<>(articleService.getAllByShipping(articles, freeShipping), HttpStatus.OK);
    }

    @GetMapping(value = "/articles", params = {"freeShipping", "prestige"})
    public ResponseEntity<List<Article>> getAllByPrestige(
            @RequestParam("freeShipping") boolean freeShipping,
            @RequestParam("prestige") String prestige
    ) throws NotFoundException {
        List<Article> articles = articleService.getAllByPrestige(prestige);
        return new ResponseEntity<>(articleService.getAllByShipping(articles, freeShipping), HttpStatus.OK);
    }

    @GetMapping(value = "articles", params = {"category", "freeShipping", "order"})
    public ResponseEntity<List<Article>> getAllSorted(
            @RequestParam("category") String category,
            @RequestParam("freeShipping") boolean freeShipping,
            @RequestParam("order") Integer order
    ) throws  NotFoundException {
        //List<List<Article>> articles = Arrays.asList(getAllByFilters(category, freeShipping).getBody());
        List<Article> articles = getAllByFilters(category, freeShipping).getBody();
        return new ResponseEntity<>(articleService.getAllSorted(articles, order), HttpStatus.OK);
    }

}

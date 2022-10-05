package com.example.desafio_spring.repository;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.model.Article;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ArticleRepository {
    String LINK_FILE = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();
    List<Article> articlesList;

    public List<Article> getAll() throws NotFoundException {

        try {
            articlesList = Arrays.asList(mapper.readValue(new File(LINK_FILE), Article[].class));
        } catch (Exception ex) {
            throw new NotFoundException("Article not found!");
        }
        return articlesList;
    }

    public List<Article> createNewArticle(Article newArticle) throws WriterValueException, NotFoundException {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        articlesList = getAll();

        articlesList = new ArrayList<>(articlesList);
        articlesList.add(newArticle);

        try {
            writer.writeValue(new File(LINK_FILE), articlesList);
        } catch (Exception ex) {
            throw new WriterValueException("The file wasn't written!");
        }
        return articlesList;
    }

    public List<Article> getAllByCategory(String category) throws NotFoundException {
        articlesList = getAll();

        return articlesList.stream()
                .filter(article -> article.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Article> getAllByShipping(List<Article> articles) {
        return articles.stream()
                .filter(Article::getFreeShipping)
                .collect(Collectors.toList());
    }

}

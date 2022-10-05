package com.example.desafio_spring.repository;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.model.Article;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ArticleRepository {
    ObjectMapper mapper = new ObjectMapper();

    public List<Article> createNewArticle(Article newArticle) throws NotFoundException {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Article> articlesList;

        String LINK_FILE = "src/main/resources/product.json";

        try {
            articlesList = Arrays.asList(mapper.readValue(new File(LINK_FILE), Article[].class));
        } catch (Exception ex) {
            throw new NotFoundException("Article not found!");
        }

        articlesList = new ArrayList<>(articlesList);
        articlesList.add(newArticle);

        try {
            writer.writeValue(new File(LINK_FILE), articlesList);
        } catch (Exception ex) {
            throw new NotFoundException("Article not found!");
        }
        return articlesList;
    }
}

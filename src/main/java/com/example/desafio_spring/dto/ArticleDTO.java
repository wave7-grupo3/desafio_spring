package com.example.desafio_spring.dto;

import com.example.desafio_spring.model.Article;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleDTO implements Serializable {
    private UUID productId;
    private String name;
    private Integer quantity;

    public ArticleDTO(Article article) {
        this.productId = article.getProductId();
        this.name = article.getName();
        this.quantity = article.getQuantity();
    }
}

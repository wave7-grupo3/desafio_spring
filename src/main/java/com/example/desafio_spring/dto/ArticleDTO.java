package com.example.desafio_spring.dto;

import com.example.desafio_spring.model.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO implements Serializable {
    private Long productId;
    private String name;
    private Long quantity;

    public ArticleDTO(Article article) {
        this.productId = article.getProductId();
        this.name = article.getName();
        this.quantity = article.getQuantity();
    }
}

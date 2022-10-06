package com.example.desafio_spring.model;

import com.example.desafio_spring.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Purchase {
    List<ArticleDTO> articlesPurchaseRequest;
}

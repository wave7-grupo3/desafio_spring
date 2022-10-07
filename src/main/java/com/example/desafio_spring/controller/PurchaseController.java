package com.example.desafio_spring.controller;

import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import com.example.desafio_spring.dto.ArticleDTO;
import com.example.desafio_spring.dto.PurchaseDTO;
import com.example.desafio_spring.model.Purchase;
import com.example.desafio_spring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchase")
    public ResponseEntity<List<ArticleDTO>> getAllPurchases() throws NotFoundException {
        return new ResponseEntity<>(purchaseService.getAllPurchases(), HttpStatus.OK);
    }

    @PostMapping("/purchase-request")
    public ResponseEntity<PurchaseDTO> createNewPurchase(@RequestBody Purchase newPurchase) throws NotFoundException, WriterValueException {
        List<ArticleDTO> articlesNewPurchase = newPurchase.getArticlesPurchaseRequest();
        return new ResponseEntity<>(purchaseService.createNewPurchase(articlesNewPurchase), HttpStatus.CREATED);
    }
}

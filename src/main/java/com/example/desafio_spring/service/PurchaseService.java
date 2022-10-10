package com.example.desafio_spring.service;

import com.example.desafio_spring.advisor.exception.NotFoundException;
import com.example.desafio_spring.advisor.exception.WriterValueException;
import com.example.desafio_spring.dto.ArticleDTO;
import com.example.desafio_spring.dto.PurchaseDTO;
import com.example.desafio_spring.model.Article;
import com.example.desafio_spring.model.Ticket;
import com.example.desafio_spring.repository.ArticleRepository;
import com.example.desafio_spring.repository.PurchaseRepository;
import com.example.desafio_spring.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PurchaseService implements IPurchase {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public List<ArticleDTO> getAllPurchases() throws NotFoundException {
        return purchaseRepository.getAllPurchases();
    }

    @Override
    public PurchaseDTO createNewPurchase(List<ArticleDTO> newPurchase) throws NotFoundException, WriterValueException {
        List<Article> articleList = articleRepository.getAll();
        List<Article> filteredArticle = new ArrayList<>();
        Double total;

        newPurchase
                .forEach(purchase -> {
                    List<Article> article = articleList.stream()
                            .filter(art -> Objects.equals(art.getProductId(), purchase.getProductId()))
                            .collect(Collectors.toList());
                    try {
                        verifyInventory(purchase, article);
                    } catch (WriterValueException | NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    filteredArticle.addAll(article);
                });

        articleRepository.updateInventory(filteredArticle);

        Ticket ticket = buildTicket(filteredArticle);

        savePurchaseInCart(ticket);

        return PurchaseDTO.builder()
                .ticket(ticket)
                .build();
    }

    private void savePurchaseInCart(Ticket ticket) throws NotFoundException, WriterValueException {
        shoppingCartRepository.save(ticket);
    }

    private Ticket buildTicket(List<Article> filteredArticle) throws NotFoundException {
        Double total;
        total = filteredArticle.stream()
                .map(article -> article.getPrice() * article.getQuantity())
                .reduce(0.0, Double::sum);

        Long ticketID = (long) (shoppingCartRepository.getAll().size() + 1);

        return Ticket.builder()
                .id(ticketID)
                .articles(filteredArticle)
                .total(total)
                .build();
    }

    private void verifyInventory(ArticleDTO purchase, List<Article> article) throws WriterValueException, NotFoundException {
        if(!article.isEmpty()) {
            try {
                if (article.get(0).getQuantity() >= purchase.getQuantity()) {
                    article.get(0).setQuantity(purchase.getQuantity());
                } else {
                    throw new NotFoundException("Insufficient quantity of " + article.get(0).getName() + " in inventory");
                }
            } catch (Exception ex) {
                throw new NotFoundException(ex.getMessage());
            }
        } else {
            throw new NotFoundException("Some article wasn't found!");
        }
    }
}

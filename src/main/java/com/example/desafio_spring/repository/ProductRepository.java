package com.example.desafio_spring.repository;

import com.example.desafio_spring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    ObjectMapper mapper = new ObjectMapper();

    public List<Product> createNewProduct(Product newProduct) {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Product> productsList;

        String LINK_FILE = "src/main/resources/products.json";

        try {
            productsList = Arrays.asList(mapper.readValue(new File(LINK_FILE), Product[].class));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        productsList = new ArrayList<>(productsList);
        productsList.add(newProduct);

        try {
            writer.writeValue(new File(LINK_FILE), productsList);
        } catch (Exception ex) {
            System.out.println("Erro ao gravar o arquivo.");
        }
        return productsList;
    }
}

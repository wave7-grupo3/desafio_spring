package com.example.desafio_spring.dto;

import com.example.desafio_spring.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CartDTO {
    private List<Ticket> tickets;
    private Double total;
}

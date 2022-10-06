package com.example.desafio_spring.dto;

import com.example.desafio_spring.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class PurchaseDTO {
    private Ticket ticket;
}

package com.example.desafio_spring.utils.validateCustomer;

import com.example.desafio_spring.advisor.exception.ConflictException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ValidateCustomer {

    public String verifyCPF(String cpf) throws ConflictException {
        if (cpf == null || cpf.isEmpty()) {
            throw new ConflictException("CPF can't be null");
        } else if (cpf.length() > 11 || cpf.length() < 11) {
            throw new ConflictException("CPF must have 11 digits");
        }
        return cpf;
    }

    public String verifyName(String name) throws ConflictException {
        if (name == null || name.isEmpty()) {
            throw new ConflictException("Name can't be null");
        } else if (name.length() < 3) {
            throw new ConflictException("Name must have at least 3 digits");
        }
        return name;
    }

    public String verifyUF(String uf) throws ConflictException {
        if (uf == null || uf.isEmpty()) {
            throw new ConflictException("UF can't be null");
        } else if (uf.length() > 2 || uf.length() < 2) {
            throw new ConflictException("UF must have 2 digits");
        }
        return uf;
    }

}

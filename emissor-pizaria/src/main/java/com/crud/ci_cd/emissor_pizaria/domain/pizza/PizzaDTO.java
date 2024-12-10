package com.crud.ci_cd.emissor_pizaria.domain.pizza;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PizzaDTO {
    @NotNull(message = "O id da pizza não pode ser nulo.")
    @Min(value = 0, message = "O id da pizza deve ser maior ou igual a zero.")
    private Long id;
    @NotBlank(message = "O nome da pizza não pode estar vazio.")
    @Size(max = 100, message = "O nome da pizza não pode ter mais de 100 caracteres.")
    private String nome;
    @NotBlank(message = "A descrição da pizza não pode estar vazio.")
    @Size(max = 100, message = "A descrição da pizza não pode ter mais de 100 caracteres.")
    private String descricao;
    @NotNull(message = "O preço da pizza não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    private BigDecimal preco;
    @NotNull(message = "O status não pode ser nulo.")
    private boolean status = true;
}
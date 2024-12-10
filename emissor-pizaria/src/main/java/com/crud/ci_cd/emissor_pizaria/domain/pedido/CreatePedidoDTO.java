package com.crud.ci_cd.emissor_pizaria.domain.pedido;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class CreatePedidoDTO {

    @NotBlank(message = "O nome do cliente não pode estar vazio.")
    @Size(max = 100, message = "O nome do cliente não pode ter mais de 100 caracteres.")
    private String cliente;

    @NotNull(message = "A lista de pizzas não pode ser nula.")
    @Size(min = 1, message = "O pedido deve conter pelo menos uma pizza.")
    private List<Long> pizzas;

    @NotNull(message = "A lista de bebidas não pode ser nula.")
    private List<Long> bebidas;

    @NotNull(message = "O status não pode ser nulo.")
    private Boolean status = true;
}

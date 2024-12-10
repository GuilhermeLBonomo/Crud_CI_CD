package com.crud.ci_cd.emissor_pizaria.domain.bebida;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateBebidaDTO {

    @NotBlank(message = "O nome da bebida não pode estar vazio.")
    @Size(max = 100, message = "O nome da bebida não pode ter mais de 100 caracteres.")
    private String nome;

    @Size(max = 100, message = "A descrição da bebida não pode ter mais de 100 caracteres.")
    private String descricao;

    @NotNull(message = "O preço da bebida não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    private BigDecimal preco;

    @NotNull(message = "O status não pode ser nulo.")
    private Boolean status = true;
}


package com.crud.ci_cd.emissor_pizaria.domain.bebida;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BebidaDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean status;
}


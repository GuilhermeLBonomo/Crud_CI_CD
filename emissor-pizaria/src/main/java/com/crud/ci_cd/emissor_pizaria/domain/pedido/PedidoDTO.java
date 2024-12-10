package com.crud.ci_cd.emissor_pizaria.domain.pedido;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PedidoDTO {
    private Long id;
    private String cliente;
    private List<Long> pizzas;
    private List<Long> bebidas;
    private Boolean status;
    private BigDecimal preco;
}

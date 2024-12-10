package com.crud.ci_cd.emissor_pizaria.application.service;


import com.crud.ci_cd.emissor_pizaria.config.MQConfig;
import com.crud.ci_cd.emissor_pizaria.domain.pedido.CreatePedidoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends BaseMessageService {

    public PedidoService(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate, MQConfig.EXCHANGE_NAME);
    }

    public void enviarPedido(CreatePedidoDTO pedidoDTO) {
        enviarMensagem(MQConfig.getRoutingKey("Pedido"), pedidoDTO);
    }
}

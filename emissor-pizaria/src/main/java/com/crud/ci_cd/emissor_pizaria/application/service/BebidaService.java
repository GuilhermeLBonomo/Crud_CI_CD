package com.crud.ci_cd.emissor_pizaria.application.service;


import com.crud.ci_cd.emissor_pizaria.config.MQConfig;
import com.crud.ci_cd.emissor_pizaria.domain.bebida.CreateBebidaDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class BebidaService extends BaseMessageService {

    public BebidaService(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate, MQConfig.EXCHANGE_NAME);
    }

    public void enviarBebida(CreateBebidaDTO bebidaDTO) {
        enviarMensagem(MQConfig.getRoutingKey("Bebida"), bebidaDTO);
    }

}


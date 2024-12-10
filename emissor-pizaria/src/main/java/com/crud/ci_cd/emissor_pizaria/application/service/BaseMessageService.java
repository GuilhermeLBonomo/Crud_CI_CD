package com.crud.ci_cd.emissor_pizaria.application.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseMessageService {

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName;

    public BaseMessageService(RabbitTemplate rabbitTemplate, String exchangeName) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchangeName = exchangeName;
    }

    protected void enviarMensagem(String routingKey, Object mensagem) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, mensagem);
    }
}



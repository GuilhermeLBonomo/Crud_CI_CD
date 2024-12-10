package com.crud.ci_cd.emissor_pizaria.application.service;

import com.crud.ci_cd.emissor_pizaria.config.MQConfig;
import com.crud.ci_cd.emissor_pizaria.domain.pizza.CreatePizzaDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PizzaService extends BaseMessageService {

    public PizzaService(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate, MQConfig.EXCHANGE_NAME);
    }

    public void enviarPizza(CreatePizzaDTO pizzaDTO) {
        enviarMensagem(MQConfig.getRoutingKey("Pizza"), pizzaDTO);
    }
}



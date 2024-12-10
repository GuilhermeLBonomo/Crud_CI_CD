package com.crud.ci_cd.emissor_pizaria.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.Map;

@Component
@Configuration
public class MQConfig {

    public static final String EXCHANGE_NAME = "PizzariaExchange";

    private static final Map<String, String> ENTITY_QUEUE_ROUTING_KEYS = Map.of(
            "Pizza", "pizzaQueue",
            "Bebida", "bebidaQueue",
            "Pedido", "pedidoQueue"
    );
    public static String getRoutingKey(String entity) {
        return ENTITY_QUEUE_ROUTING_KEYS.get(entity);
    }

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    private void setupQueuesAndExchanges() {
        DirectExchange directExchange = new DirectExchange(EXCHANGE_NAME);
        amqpAdmin.declareExchange(directExchange);

        ENTITY_QUEUE_ROUTING_KEYS.forEach((entity, queueName) -> {
            Queue queue = createQueue(queueName);
            amqpAdmin.declareQueue(queue);

            Binding binding = BindingBuilder
                    .bind(queue)
                    .to(directExchange)
                    .with(queueName);
            amqpAdmin.declareBinding(binding);
        });
    }

    private Queue createQueue(String queueName) {
        return new Queue(queueName, true, false, false);
    }
}

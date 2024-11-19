package com.kwanse.shop.clothes.infra.rabbitmq;

import com.kwanse.shop.clothes.command.application.ClothesSender;
import com.kwanse.shop.clothes.command.domain.Clothes;
import com.kwanse.shop.clothes.command.domain.ClothesSavedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitClothesSender implements ClothesSender {

    @Value("${rabbitmq.queue.queue1.exchange}")
    private String exchange;
    @Value("${rabbitmq.queue.routing.key.queue1}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;


    @Override
    public void send(Clothes clothes) {
        ClothesSavedEvent event = new ClothesSavedEvent(clothes);
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
    }
}

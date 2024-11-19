package com.kwanse.shop.clothes.infra.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitClothesConfig {

    @Value("${rabbitmq.queue.queue1.name}")
    private String queue1;

    @Value("${rabbitmq.queue.queue1.exchange}")
    private String exchange1;

    @Value("${rabbitmq.queue.routing.key.queue1}")
    private String routingKey1;

    @Bean
    public Queue queue1() {
        return new Queue(queue1, true);
    }

    @Bean
    public DirectExchange directExchange1() {
        return new DirectExchange(exchange1);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(directExchange1()).with(routingKey1);
    }
}

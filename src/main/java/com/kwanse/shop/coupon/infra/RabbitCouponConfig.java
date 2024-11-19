package com.kwanse.shop.coupon.infra;

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
public class RabbitCouponConfig {

    @Value("${rabbitmq.queue.queue3.name}")
    private String queue3;

    @Value("${rabbitmq.queue.queue3.exchange}")
    private String exchange3;

    @Value("${rabbitmq.queue.routing.key.queue3}")
    private String routingKey3;

    @Bean
    public Queue queue3() {
        return new Queue(queue3, true);
    }

    @Bean
    public DirectExchange directExchange3() {
        return new DirectExchange(exchange3);
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(directExchange3()).with(routingKey3);
    }
}

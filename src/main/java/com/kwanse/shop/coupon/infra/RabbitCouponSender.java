package com.kwanse.shop.coupon.infra;

import com.kwanse.shop.coupon.command.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RabbitCouponSender {

    @Value("${rabbitmq.queue.queue3.exchange}")
    private String exchange;
    @Value("${rabbitmq.queue.routing.key.queue3}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

//    @Override
    public void send(Coupon coupon) {

    }
}

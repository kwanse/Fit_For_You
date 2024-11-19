package com.kwanse.shop.coupon.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RabbitCouponListener {

    @RabbitListener(queues = "coupon")
    public void receiveMessage() {

    }
}

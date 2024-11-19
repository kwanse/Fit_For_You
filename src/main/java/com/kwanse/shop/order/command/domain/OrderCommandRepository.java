package com.kwanse.shop.order.command.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderCommandRepository {
    Order save(Order order);
}

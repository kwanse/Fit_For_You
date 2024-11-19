package com.kwanse.shop.order.query;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderDetailDao extends MongoRepository<OrderDetail, Long> {
}

package com.kwanse.shop.order.query;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderSummaryDao extends MongoRepository<OrderSummary, Long> {
}

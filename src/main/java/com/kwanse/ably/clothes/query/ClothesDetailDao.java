package com.kwanse.ably.clothes.query;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClothesDetailDao extends MongoRepository<ClothesDetail, Long> {
}

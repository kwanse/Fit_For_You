package com.kwanse.ably.clothes.query;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClothesSummaryDao extends MongoRepository<ClothesSummary, Long> {

    @Query
    List<ClothesSummary> findClothesSummaryByIdAfter(Long id, int limit);
}

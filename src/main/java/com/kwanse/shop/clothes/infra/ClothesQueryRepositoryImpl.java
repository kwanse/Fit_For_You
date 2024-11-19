package com.kwanse.shop.clothes.infra;

import com.kwanse.shop.clothes.query.ClothesQueryRepositoryCustom;
import com.kwanse.shop.clothes.query.application.dto.ClothesSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ClothesQueryRepositoryImpl implements ClothesQueryRepositoryCustom {

    private static final int PAGE_SIZE = 20;
    private final MongoTemplate mongoTemplate;

    @Override
    public List<ClothesSummary> findSummaryByLastId(Long lastId) {
        Criteria criteria = createCriteria(lastId);
        Query query = new Query(criteria)
                .with(Sort.by(Sort.Direction.DESC, "_id"))
                .limit(PAGE_SIZE);
        return mongoTemplate.find(query, ClothesSummary.class, "clothesView");
    }

    private Criteria createCriteria(Long lastId) {
        if (lastId != null) {
            return Criteria.where("_id").lte(lastId);
        }
        return new Criteria();
    }

    @Override
    public List<ClothesSummary> findRanking() {
        Query query = new Query()
                .with(Sort.by(Sort.Direction.DESC, "salesVolume"))
                .limit(50);

        return mongoTemplate.find(query, ClothesSummary.class, "clothesView");
    }
}

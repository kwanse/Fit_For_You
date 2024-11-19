package com.kwanse.shop.clothes.query.application;

import com.kwanse.shop.clothes.query.application.dto.ClothesDetail;
import com.kwanse.shop.clothes.query.application.dto.ClothesSummary;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RedisClothesService {
    Optional<ClothesDetail> getCachedDetail(Long clothesId);

    void cacheClothesDetail(ClothesDetail savedDetail);

    List<ClothesSummary> getCachedSummaries(Long lastId);

    void cacheClothesSummary(
            Long lastId,
            List<ClothesSummary> savedSummaries
    );
}

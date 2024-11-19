package com.kwanse.shop.clothes.query.application;

import com.kwanse.shop.clothes.query.ClothesQueryRepository;
import com.kwanse.shop.clothes.query.application.dto.ClothesDetail;
import com.kwanse.shop.clothes.query.application.dto.ClothesSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.kwanse.shop.clothes.ClothesConst.RANKED_CLOTHES_SUMMARY_CACHE;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ClothesQueryService {

    private final ClothesQueryRepository clothesQueryRepository;
    private final RedisClothesService redisClothesService;

    @Cacheable(value = RANKED_CLOTHES_SUMMARY_CACHE, cacheManager = "localCacheManager")
    public List<ClothesSummary> getRankedClothesSummary() {
        return clothesQueryRepository.findRanking();
    }


    public List<ClothesSummary> getClothesSummary(final Long lastId) {
        List<ClothesSummary> cachedSummaries = redisClothesService.getCachedSummaries(lastId);
        if (cachedSummaries != null) {
            return cachedSummaries;
        }
        return findAndCacheSummariesFromDb(lastId);
    }

    private List<ClothesSummary> findAndCacheSummariesFromDb(final Long lastId) {
        List<ClothesSummary> savedSummaries = clothesQueryRepository.findSummaryByLastId(lastId);
        redisClothesService.cacheClothesSummary(lastId, savedSummaries);
        return savedSummaries;
    }


    public ClothesDetail getClothesDetail(final Long clothesId) {
        return redisClothesService.getCachedDetail(clothesId)
                .orElseGet(() -> findAndCacheDetailFromDb(clothesId));
    }

    private ClothesDetail findAndCacheDetailFromDb(final Long clothesId) {
        ClothesDetail savedDetail = clothesQueryRepository.findDetailById(clothesId)
                .orElse(ClothesDetail.EMPTY);
        redisClothesService.cacheClothesDetail(savedDetail);
        return savedDetail;
    }
}

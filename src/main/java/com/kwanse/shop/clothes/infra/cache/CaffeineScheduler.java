package com.kwanse.shop.clothes.infra.cache;

import com.kwanse.shop.clothes.query.application.ClothesQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.kwanse.shop.clothes.ClothesConst.RANKED_CLOTHES_SUMMARY_CACHE;

@RequiredArgsConstructor
@Component
public class CaffeineScheduler {

    private final ClothesQueryService clothesQueryService;
    private final CacheManager cacheManager;

    @Scheduled(cron = "0 0 6 * * *")
    public void cachePopularClothes() {
        Cache cache = cacheManager.getCache(RANKED_CLOTHES_SUMMARY_CACHE);
        if (cache != null) {
            cache.clear();
        }
        clothesQueryService.getRankedClothesSummary();
    }
}

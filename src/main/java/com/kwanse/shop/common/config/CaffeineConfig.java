package com.kwanse.shop.common.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static com.kwanse.shop.clothes.ClothesConst.RANKED_CLOTHES_SUMMARY_CACHE;

@EnableCaching
@Configuration
public class CaffeineConfig {

    @Bean
    public Caffeine<Object, Object> caffeineCache() {
        return Caffeine
                .newBuilder()
                .initialCapacity(100)
                .maximumSize(10_00);
    }

    @Bean
    @Primary
    public CacheManager localCacheManager(Caffeine<Object, Object> caffeine) {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(RANKED_CLOTHES_SUMMARY_CACHE);
        cacheManager.setCaffeine(caffeine);
        return cacheManager;
    }
}

package com.kwanse.shop.clothes.infra.cache;

import com.kwanse.shop.clothes.query.application.RedisClothesService;
import com.kwanse.shop.clothes.query.application.dto.ClothesDetail;
import com.kwanse.shop.clothes.query.application.dto.ClothesSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class RedisClothesServiceImpl implements RedisClothesService {

    private static final String REDIS_CLOTHES_DETAIL_KEY = "clothesDetail:";
    private static final String REDIS_CLOTHES_SUMMARIES_KEY = "clothesSummaries:";
    private static final Random RANDOM = new Random();

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public Optional<ClothesDetail> getCachedDetail(final Long clothesId) {
        String redisKey = generateDetailKey(clothesId.toString());
        ClothesDetail cachedDetail =
                (ClothesDetail) redisTemplate.opsForValue().get(redisKey);

        return Optional.ofNullable(cachedDetail);
    }

    @Override
    public void cacheClothesDetail(final ClothesDetail savedDetail) {
        Long id = savedDetail.getId();
        String redisKey = generateDetailKey(id.toString());
        redisTemplate.opsForValue().set(redisKey, savedDetail, generateTtl());
    }


    @Override
    public List<ClothesSummary> getCachedSummaries(final Long lastId) {
        if (lastId == null) {
            String redisKey = generateSummariesKey("0");
            return (List<ClothesSummary>) redisTemplate.opsForValue().get(redisKey);
        }
        String redisKey = generateSummariesKey(lastId.toString());
        return (List<ClothesSummary>) redisTemplate.opsForValue().get(redisKey);
    }

    @Override
    public void cacheClothesSummary(
            final Long lastId,
            final List<ClothesSummary> savedSummaries
    ) {
        if (lastId == null) {
            String redisKey = generateSummariesKey("0");
            redisTemplate.opsForValue().set(redisKey, savedSummaries, generateTtl());
            return;
        }
        String redisKey = generateSummariesKey(lastId.toString());
        redisTemplate.opsForValue().set(redisKey, savedSummaries, generateTtl());
    }


    private String generateDetailKey(String param) {
        return REDIS_CLOTHES_DETAIL_KEY + param;
    }

    private String generateSummariesKey(String param) {
        return REDIS_CLOTHES_SUMMARIES_KEY + param;
    }

    private Duration generateTtl() {
        long randomSeconds = RANDOM.nextLong(60);
        return Duration.ofSeconds(300 + randomSeconds);
    }
}

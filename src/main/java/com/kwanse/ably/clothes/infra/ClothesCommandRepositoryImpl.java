package com.kwanse.ably.clothes.infra;

import com.kwanse.ably.clothes.command.domain.Clothes;
import com.kwanse.ably.clothes.command.domain.ClothesCommandRepository;
import com.kwanse.ably.clothes.query.ClothesDetail;
import com.kwanse.ably.clothes.query.ClothesDetailDao;
import com.kwanse.ably.clothes.query.ClothesSummary;
import com.kwanse.ably.clothes.query.ClothesSummaryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClothesCommandRepositoryImpl implements ClothesCommandRepository {

    private final ClothesJpaRepository clothesJpaRepository;

    private final ClothesDetailDao clothesDetailDao;
    private final ClothesSummaryDao clothesSummaryDao;

    @Override
    public Clothes save(Clothes clothes) {
        clothesJpaRepository.save(clothes);

        ClothesDetail clothesDetail = ClothesDetail.of(clothes);
        clothesDetailDao.save(clothesDetail);

        ClothesSummary clothesSummary = ClothesSummary.of(clothes);
        clothesSummaryDao.save(clothesSummary);
        return clothes;
    }

}

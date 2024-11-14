package com.kwanse.ably.clothes.query.application;

import com.kwanse.ably.clothes.query.ClothesDetail;
import com.kwanse.ably.clothes.query.ClothesDetailDao;
import com.kwanse.ably.clothes.query.ClothesSummary;
import com.kwanse.ably.clothes.query.ClothesSummaryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesQueryService {

    private static final int PAGE_SIZE = 20;

    private final ClothesDetailDao clothesDetailDao;
    private final ClothesSummaryDao clothesSummaryDao;

    public ClothesDetail getClothesDetail(Long clothesId) {
        return clothesDetailDao.findById(clothesId)
                .orElse(ClothesDetail.EMPTY);
    }

    public List<ClothesSummary> getClothesSummary(Long clothesId) {
        return clothesSummaryDao
                .findClothesSummaryByIdAfter(clothesId, PAGE_SIZE);
    }

}

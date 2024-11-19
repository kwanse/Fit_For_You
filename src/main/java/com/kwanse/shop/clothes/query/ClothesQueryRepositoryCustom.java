package com.kwanse.shop.clothes.query;

import com.kwanse.shop.clothes.query.application.dto.ClothesSummary;

import java.time.LocalDateTime;
import java.util.List;

public interface ClothesQueryRepositoryCustom {

    List<ClothesSummary> findSummaryByLastId(Long lastId);

    List<ClothesSummary> findRanking();
}

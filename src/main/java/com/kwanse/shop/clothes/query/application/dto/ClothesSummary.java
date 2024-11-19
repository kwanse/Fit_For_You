package com.kwanse.shop.clothes.query.application.dto;

import com.kwanse.shop.clothes.command.domain.value.ClothesInfo;
import com.kwanse.shop.clothes.command.domain.value.Seller;
import lombok.Getter;

@Getter
public final class ClothesSummary {
    private Long id;

    private ClothesInfo clothesInfo;
    private Seller seller;

}

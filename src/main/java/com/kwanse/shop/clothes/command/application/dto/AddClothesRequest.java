package com.kwanse.shop.clothes.command.application.dto;

import com.kwanse.shop.clothes.command.domain.Clothes;
import com.kwanse.shop.clothes.command.domain.ClothesItem;
import com.kwanse.shop.clothes.command.domain.value.*;
import com.kwanse.shop.common.model.Money;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

import static com.kwanse.shop.clothes.ClothesConst.MAX_TITLE_SIZE;
import static com.kwanse.shop.clothes.ClothesConst.MIN_TITLE_SIZE;

public record AddClothesRequest(

        @Size(min = MIN_TITLE_SIZE, max = MAX_TITLE_SIZE)
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotBlank
        BigDecimal price,

        Integer categoryCode,
        Long sellerId,
        String sellerName,

        OptionInfo optionInfo
) {

    private static class OptionInfo {

        private Integer stock;
        private String size;
        private String color;
    }

    public Clothes to() {
        Seller seller = new Seller(sellerId, sellerName);
        ClothesInfo clothesInfo = createInfo();
        Clothes clothes = createClothes(seller, clothesInfo);

        ClothesItem clothesItem = createItem();

        clothes.addItems(clothesItem);
        return clothes;
    }

    private Clothes createClothes(Seller seller, ClothesInfo clothesInfo) {
        return Clothes.builder()
                .seller(seller)
                .clothesInfo(clothesInfo)
                .build();
    }

    private ClothesItem createItem() {
        return ClothesItem.builder()
                .stock(optionInfo().stock)
                .color(new Color(optionInfo.color))
                .size(new ClothesSize(optionInfo.size))
                .build();
    }

    private ClothesInfo createInfo() {
        return ClothesInfo.builder()
                .title(title)
                .description(description)
                .category(Category.fromCode(categoryCode))
                .price(new Money(price))
                .build();
    }
}

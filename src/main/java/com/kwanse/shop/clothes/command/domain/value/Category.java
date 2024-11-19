package com.kwanse.shop.clothes.command.domain.value;

import java.util.Arrays;

import static com.kwanse.shop.clothes.ClothesConst.CATEGORY_PANTS_CODE;
import static com.kwanse.shop.clothes.ClothesConst.CATEGORY_TOP_CODE;

public enum Category {

    TOP(CATEGORY_TOP_CODE),
    PANTS(CATEGORY_PANTS_CODE);

    private final Integer code;

    Category(Integer code) {
        this.code = code;
    }

    public static Category fromCode(Integer code) {
        return Arrays.stream(Category.values())
                .filter(category -> category.code.equals(code))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException("Invalid category code: " + code));
    }
}

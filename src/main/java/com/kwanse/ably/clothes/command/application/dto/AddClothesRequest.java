package com.kwanse.ably.clothes.command.application.dto;

import com.kwanse.ably.clothes.command.domain.Clothes;
import com.kwanse.ably.clothes.command.domain.value.ClothesSize;
import com.kwanse.ably.clothes.command.domain.value.Color;
import com.kwanse.ably.clothes.command.domain.value.Seller;
import com.kwanse.ably.common.model.Category;
import com.kwanse.ably.common.model.Money;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

import static com.kwanse.ably.clothes.command.ClothesConst.*;

public record AddClothesRequest(

        @Size(min = MIN_TITLE_SIZE, max = MAX_TITLE_SIZE)
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotBlank
        BigDecimal price,

        Category category,

        Long sellerId,

        String sellerName,

        @Size(max = MAX_CLOTHES_COLOR)
        List<String> colors,

        @Size(max = MAX_CLOTHES_SIZE)
        List<String> sizes
) {

    public Clothes to() {

        Seller seller = new Seller(sellerId, sellerName);

        List<Color> colorList = colors.stream()
                .map(Color::new)
                .toList();

        List<ClothesSize> sizeList = sizes.stream()
                .map(ClothesSize::new)
                .toList();

        return Clothes.builder()
                .title(title)
                .description(description)
                .category(category)
                .price(new Money(price))
                .seller(seller)
                .colors(colorList)
                .sizes(sizeList)
                .build();
    }
}

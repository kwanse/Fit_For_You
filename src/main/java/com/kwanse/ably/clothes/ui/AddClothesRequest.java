package com.kwanse.ably.clothes.ui;

import com.kwanse.ably.clothes.command.domain.*;
import com.kwanse.ably.common.model.Money;
import com.kwanse.ably.member.MemberId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

import static com.kwanse.ably.clothes.command.ProductConst.*;

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

        @Size(max = MAX_IMAGE_SIZE)
        List<MultipartFile> images,

        @Size(max = MAX_CLOTHES_COLOR)
        List<String> colors,

        @Size(max = MAX_CLOTHES_SIZE)
        List<String> sizes
) {

    public Clothes to() {

        MemberId memberId = new MemberId(sellerId);
        Seller seller = new Seller(memberId, sellerName);

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

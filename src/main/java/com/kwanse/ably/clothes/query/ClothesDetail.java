package com.kwanse.ably.clothes.query;

import com.kwanse.ably.clothes.command.domain.Clothes;
import com.kwanse.ably.clothes.command.domain.value.ClothesSize;
import com.kwanse.ably.clothes.command.domain.value.Color;
import com.kwanse.ably.clothes.command.domain.value.Seller;
import com.kwanse.ably.common.model.Category;
import com.kwanse.ably.common.model.Image;
import com.kwanse.ably.common.model.Money;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class ClothesDetail {

    public static final ClothesDetail EMPTY = new ClothesDetail();

    @Id
    private Long id;

    private String title;

    private String description;

    private Money price;

    private Seller seller;

    private Category category;

    private List<Image> images;

    private List<ClothesSize> sizes;

    private List<Color> colors;

    private ClothesDetail(
            Long id,
            String title,
            String description,
            Money price,
            Seller seller,
            Category category,
            List<Image> images,
            List<ClothesSize> sizes,
            List<Color> colors
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.category = category;
        this.images = images;
        this.sizes = sizes;
        this.colors = colors;
    }

    public static ClothesDetail of(Clothes clothes) {
        return new ClothesDetail(
                clothes.getId(),
                clothes.getTitle(),
                clothes.getDescription(),
                clothes.getPrice(),
                clothes.getSeller(),
                clothes.getCategory(),
                clothes.getImages(),
                clothes.getSizes(),
                clothes.getColors()
        );
    }
}

package com.kwanse.ably.clothes.command.domain;

import com.kwanse.ably.clothes.command.domain.value.ClothesSize;
import com.kwanse.ably.clothes.command.domain.value.Color;
import com.kwanse.ably.clothes.command.domain.value.Seller;
import com.kwanse.ably.common.model.Category;
import com.kwanse.ably.common.model.DiscountRate;
import com.kwanse.ably.common.model.Image;
import com.kwanse.ably.common.model.Money;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Embedded
    private Money price;

    @Embedded
    private Seller seller;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ElementCollection
    @CollectionTable(
            name = "image",
            joinColumns = @JoinColumn(name = "clothes_id")
    )
    private List<Image> images = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "size",
            joinColumns = @JoinColumn(name = "clothes_id")
    )
    private List<ClothesSize> sizes;

    @ElementCollection
    @CollectionTable(
            name = "color",
            joinColumns = @JoinColumn(name = "clothes_id")
    )
    private List<Color> colors;


    public Money discountOf(DiscountRate discountRate) {
        return this.price.discountOf(discountRate);
    }

    public void addImages(List<Image> images) {
        this.images = images;
    }

    @Builder
    public Clothes(
            String title,
            String description,
            Money price, Seller seller,
            Category category,
            List<ClothesSize> sizes,
            List<Color> colors
    ) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.category = category;
        this.sizes = sizes;
        this.colors = colors;
    }
}

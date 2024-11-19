package com.kwanse.shop.clothes.command.domain;

import com.kwanse.shop.clothes.command.domain.value.ClothesInfo;
import com.kwanse.shop.clothes.command.domain.value.Seller;
import com.kwanse.shop.common.model.BaseEntity;
import com.kwanse.shop.common.model.DiscountRate;
import com.kwanse.shop.common.model.Image;
import com.kwanse.shop.common.model.Money;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Clothes extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long salesVolume;

    @Embedded
    private Seller seller;

    @Embedded
    private ClothesInfo clothesInfo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "clothes_item_id")
    private List<ClothesItem> clothesItems = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "image",
            joinColumns = @JoinColumn(name = "clothes_id")
    )
    private List<Image> images = new ArrayList<>();


    @Builder
    public Clothes(
            Seller seller,
            ClothesInfo clothesInfo
    ) {
        this.seller = seller;
        this.clothesInfo = clothesInfo;
    }


    public Money discountOf(final DiscountRate discountRate) {
        Money originalPrice = this.clothesInfo.getPrice();
        return originalPrice.discountOf(discountRate);
    }

    public void addItems(final ClothesItem item) {
        this.clothesItems.add(item);
    }

    public void addImages(final List<Image> images) {
        this.images.addAll(images);
    }

    public void sell(int quantity) {

        this.salesVolume += quantity;
    }
}

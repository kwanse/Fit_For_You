package com.kwanse.shop.clothes.query;

import com.kwanse.shop.clothes.command.domain.Clothes;
import com.kwanse.shop.clothes.command.domain.ClothesItem;
import com.kwanse.shop.clothes.command.domain.value.ClothesInfo;
import com.kwanse.shop.clothes.command.domain.value.ClothesSize;
import com.kwanse.shop.clothes.command.domain.value.Color;
import com.kwanse.shop.clothes.command.domain.value.Seller;
import com.kwanse.shop.common.model.Image;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Document
public class ClothesView {

    @Id
    private Long id;

    @Indexed
    private Long salesVolume;

    private ClothesInfo clothesInfo;
    private Seller seller;

    private List<Image> images;
    private List<ClothesSize> sizes;
    private List<Color> colors;

    @Indexed
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClothesView(Clothes clothes) {
        this.id = clothes.getId();
        this.salesVolume = clothes.getSalesVolume();

        this.clothesInfo = clothes.getClothesInfo();
        this.seller = clothes.getSeller();
        this.images = clothes.getImages();

        this.sizes = clothes.getClothesItems().stream()
                .map(ClothesItem::getSize)
                .toList();

        this.colors = clothes.getClothesItems().stream()
                .map(ClothesItem::getColor)
                .toList();

        this.createdAt = clothes.getCreatedAt();
        this.updatedAt = clothes.getUpdatedAt();
    }
}

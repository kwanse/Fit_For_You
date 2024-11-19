package com.kwanse.shop.clothes.command.domain;

import com.kwanse.shop.clothes.command.domain.value.ClothesSize;
import com.kwanse.shop.clothes.command.domain.value.Color;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ClothesItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer stock;

    @Embedded
    private ClothesSize size;
    @Embedded
    private Color color;

    @Builder
    public ClothesItem(Integer stock, ClothesSize size, Color color) {
        this.stock = stock;
        this.size = size;
        this.color = color;
    }
}

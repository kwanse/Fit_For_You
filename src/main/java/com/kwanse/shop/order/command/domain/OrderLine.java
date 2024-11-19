package com.kwanse.shop.order.command.domain;

import com.kwanse.shop.clothes.command.domain.value.ClothesSize;
import com.kwanse.shop.clothes.command.domain.value.Color;
import com.kwanse.shop.common.model.Money;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderLine {

    @Column(name = "ordered_clothes_id")
    private Long clothesId;

    private String title;

    @Embedded
    private Color color;

    @Embedded
    private ClothesSize clothesSize;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "price"))
    private Money price;

    private Integer quantity;

    @Embedded
    private AppliedCoupon appliedCoupon;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "amount"))
    private Money amount;


}

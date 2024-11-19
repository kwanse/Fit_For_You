package com.kwanse.shop.clothes.command.domain.value;

import com.kwanse.shop.common.model.Money;
import jakarta.persistence.*;
import lombok.*;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ClothesInfo {

    private String title;

    private String description;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "clothes_price"))
    private Money price;

    @Enumerated(EnumType.STRING)
    @Column(name = "clothes_category")
    private Category category;

    @Builder
    public ClothesInfo(
            String title,
            String description,
            Money price,
            Category category
    ) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}

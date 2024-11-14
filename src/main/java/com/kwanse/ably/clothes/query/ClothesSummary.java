package com.kwanse.ably.clothes.query;

import com.kwanse.ably.clothes.command.domain.Clothes;
import com.kwanse.ably.clothes.command.domain.value.Seller;
import com.kwanse.ably.common.model.Money;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class ClothesSummary {

    public static ClothesSummary EMPTY = new ClothesSummary();

    @Id
    private Long id;

    private String title;
    private Seller seller;
    private Money price;

    public ClothesSummary(Long id, String title, Seller seller, Money price) {
        this.id = id;
        this.title = title;
        this.seller = seller;
        this.price = price;
    }

    public static ClothesSummary of(Clothes clothes) {
        return new ClothesSummary(
                clothes.getId(),
                clothes.getTitle(),
                clothes.getSeller(),
                clothes.getPrice()
        );
    }
}

package com.kwanse.shop.clothes.command.domain.value;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Seller {

    @Column(name = "seller_id")
    private Long memberId;
    private String name;

    @Builder
    public Seller(Long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}

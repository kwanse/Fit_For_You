package com.kwanse.ably.clothes.command.domain.value;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {

    @Column(name = "seller_id")
    private Long memberId;
    private String name;

    public Seller(Long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}

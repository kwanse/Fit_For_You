package com.kwanse.ably.order.command.domain;

import com.kwanse.ably.common.model.Category;
import com.kwanse.ably.common.model.DiscountRate;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AppliedCoupon {

    private Long couponId;

    private String name;

    @Enumerated(EnumType.STRING)
    private DiscountRate discountRate;

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDateTime expiryDateTime;

    @Builder
    public AppliedCoupon(
            Long couponId,
            String name,
            DiscountRate discountRate,
            Category category,
            LocalDateTime expiryDateTime
    ) {
        this.couponId = couponId;
        this.name = name;
        this.discountRate = discountRate;
        this.category = category;
        this.expiryDateTime = expiryDateTime;
    }
}

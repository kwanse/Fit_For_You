package com.kwanse.ably.coupon;

import com.kwanse.ably.common.model.DiscountRate;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @EmbeddedId
    private CouponId id;

    private String name;

    private LocalDateTime expiryDate;

    private Long amount;

    @Enumerated(EnumType.STRING)
    private DiscountRate discountRate;

    @Enumerated(EnumType.STRING)
    private Range range;


    public void issue() {
        this.amount -= 1;
    }

}

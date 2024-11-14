package com.kwanse.ably.coupon.query;

import com.kwanse.ably.coupon.command.domain.Coupon;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponSummary {

    @Indexed
    Long memberId;

    String couponName;
    String range;
    int discountRate;

    @Indexed
    LocalDateTime expiryDateTime;

    private CouponSummary(Long memberId, String couponName, String range, int discountRate, LocalDateTime expiryDateTime) {
        this.memberId = memberId;
        this.couponName = couponName;
        this.range = range;
        this.discountRate = discountRate;
        this.expiryDateTime = expiryDateTime;
    }

    public static CouponSummary of(Coupon coupon) {
        return new CouponSummary(
                coupon.getId(),
                coupon.getName(),
                coupon.getCategory().name(),
                coupon.getDiscountRate().getDiscountPercentage(),
                coupon.getExpiryDateTime()
        );
    }
}

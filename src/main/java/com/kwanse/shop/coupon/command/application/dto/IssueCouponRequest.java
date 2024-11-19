package com.kwanse.shop.coupon.command.application.dto;

import java.time.LocalDateTime;
import java.util.List;

public record IssueCouponRequest(
        String couponName,
        Long amount,
        String discountRate,
        String category,
        List<Long> memberIds,
        LocalDateTime expiryDateTime
) {

}

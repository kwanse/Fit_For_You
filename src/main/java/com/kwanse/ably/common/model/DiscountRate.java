package com.kwanse.ably.common.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public enum DiscountRate {

    FIVE_PERCENT(5, new BigDecimal("0.95")),
    TEN_PERCENT(10, new BigDecimal("0.90")),
    FIFTEEN_PERCENT(15, new BigDecimal("0.85")),
    TWENTY_PERCENT(20, new BigDecimal("0.80")),;

    private final int discountPercentage;
    private final BigDecimal paymentPercentage;

}

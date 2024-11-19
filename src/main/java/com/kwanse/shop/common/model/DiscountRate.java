package com.kwanse.shop.common.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum DiscountRate {

    FIVE_PERCENT(5),
    TEN_PERCENT(10),
    FIFTEEN_PERCENT(15),
    TWENTY_PERCENT(20);

    private final int discountPercentage;
    private final BigDecimal paymentPercentage;

    DiscountRate(int discountPercentage) {
        this.discountPercentage = discountPercentage;
        this.paymentPercentage = new BigDecimal(100 - discountPercentage);
    }
}

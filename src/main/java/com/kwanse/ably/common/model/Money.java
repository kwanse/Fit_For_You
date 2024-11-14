package com.kwanse.ably.common.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Money {

    @Column(name = "money")
    private BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value;
    }

    public Money discountOf(DiscountRate discountRate) {
        BigDecimal paymentRate = discountRate.getPaymentPercentage();
        BigDecimal discountedPrice = value.multiply(paymentRate);

        return new Money(discountedPrice);
    }
}

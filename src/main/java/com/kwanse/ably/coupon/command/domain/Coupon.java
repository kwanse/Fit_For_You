package com.kwanse.ably.coupon.command.domain;

import com.kwanse.ably.common.model.Category;
import com.kwanse.ably.common.model.DiscountRate;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long amount;

    @Enumerated(EnumType.STRING)
    private DiscountRate discountRate;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "issued_coupon",joinColumns = @JoinColumn(name = "coupon_id"))
    private List<IssuedCoupon> issuedCoupons;

    private LocalDateTime expiryDateTime;

    @Builder
    public Coupon(
            String name,
            Long amount,
            DiscountRate discountRate,
            Category category,
            List<IssuedCoupon> issuedCoupons,
            LocalDateTime expiryDateTime
    ) {
        this.name = name;
        this.amount = amount;
        this.discountRate = discountRate;
        this.category = category;
        this.issuedCoupons = issuedCoupons;
        this.expiryDateTime = expiryDateTime;
    }

    public void issue() {
        this.amount -= 1;
    }


}

package com.kwanse.ably.coupon;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class CouponId implements Serializable {

    @Column(name = "column_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public CouponId(Long id) {
        this.id = id;
    }

    public static CouponId of(Long id) {
        return new CouponId(id);
    }
}

package com.kwanse.ably.membercoupon;

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
public class MemberCouponId implements Serializable {

    @Column(name = "member_coupon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public MemberCouponId(Long id) {
        this.id = id;
    }

    public static MemberCouponId of(Long id) {
        return new MemberCouponId(id);
    }
}

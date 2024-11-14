package com.kwanse.ably.coupon.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IssuedCoupon {

    @Column(name = "applied_member_id")
    private Long memberId;

    private boolean isUsed;

    public IssuedCoupon(Long memberId) {
        this.memberId = memberId;
        this.isUsed = false;
    }
}

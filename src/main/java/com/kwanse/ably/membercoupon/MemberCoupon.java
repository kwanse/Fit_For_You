package com.kwanse.ably.membercoupon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCoupon {

    @Id @Column(name = "member_coupon_id")
    private Long id;

    private Long couponId;

    private Long memberId;

    private boolean isUsed;

}

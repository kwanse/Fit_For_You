package com.kwanse.ably.coupon.infra;

import com.kwanse.ably.coupon.command.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {
}

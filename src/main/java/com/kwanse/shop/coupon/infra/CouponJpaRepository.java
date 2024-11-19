package com.kwanse.shop.coupon.infra;

import com.kwanse.shop.coupon.command.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {
}

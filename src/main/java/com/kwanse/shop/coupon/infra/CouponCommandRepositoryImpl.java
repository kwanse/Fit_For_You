package com.kwanse.shop.coupon.infra;

import com.kwanse.shop.coupon.command.domain.Coupon;
import com.kwanse.shop.coupon.command.domain.CouponCommandRepository;
import com.kwanse.shop.coupon.query.CouponSummary;
import com.kwanse.shop.coupon.query.CouponSummaryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CouponCommandRepositoryImpl implements CouponCommandRepository {

    private final CouponJpaRepository couponJpaRepository;

    private final CouponSummaryDao couponSummaryDao;

    @Override
    public Coupon save(Coupon coupon) {
        couponJpaRepository.save(coupon);

        CouponSummary couponSummary = CouponSummary.of(coupon);
        couponSummaryDao.save(couponSummary);
        return coupon;
    }
}

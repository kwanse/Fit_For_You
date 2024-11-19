package com.kwanse.shop.coupon.query.application;

import com.kwanse.shop.coupon.query.CouponSummary;
import com.kwanse.shop.coupon.query.CouponSummaryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CouponQueryService {

    private final CouponSummaryDao couponSummaryDao;

    public List<CouponSummary> findAllByMemberId(Long memberId) {
        return couponSummaryDao.findAllByMemberId(memberId);
    }
}

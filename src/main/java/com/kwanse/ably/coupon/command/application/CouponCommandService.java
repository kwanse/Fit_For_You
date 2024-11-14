package com.kwanse.ably.coupon.command.application;

import com.kwanse.ably.common.model.Category;
import com.kwanse.ably.common.model.DiscountRate;
import com.kwanse.ably.coupon.command.application.dto.IssueCouponRequest;
import com.kwanse.ably.coupon.command.domain.Coupon;
import com.kwanse.ably.coupon.command.domain.CouponCommandRepository;
import com.kwanse.ably.coupon.command.domain.IssuedCoupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CouponCommandService {

    private final CouponCommandRepository commandRepository;

    public Long issueCoupon(IssueCouponRequest request) {
        List<IssuedCoupon> issuedCoupons = request.memberIds().stream()
                .map(IssuedCoupon::new)
                .toList();

        Coupon coupon = createCoupon(request, issuedCoupons);
        return commandRepository.save(coupon).getId();
    }

    private Coupon createCoupon(IssueCouponRequest request, List<IssuedCoupon> issuedCoupons) {
        DiscountRate discountRate = DiscountRate.valueOf(request.discountRate());
        Category category = Category.valueOf(request.category());

        return Coupon.builder()
                .name(request.couponName())
                .amount(request.amount())
                .discountRate(discountRate)
                .category(category)
                .issuedCoupons(issuedCoupons)
                .expiryDateTime(request.expiryDateTime())
                .build();
    }
}

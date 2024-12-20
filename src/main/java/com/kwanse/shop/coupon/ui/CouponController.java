package com.kwanse.shop.coupon.ui;

import com.kwanse.shop.common.Response;
import com.kwanse.shop.coupon.command.application.CouponCommandService;
import com.kwanse.shop.coupon.command.application.dto.IssueCouponRequest;
import com.kwanse.shop.coupon.query.CouponSummary;
import com.kwanse.shop.coupon.query.application.CouponQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final CouponCommandService couponCommandService;
    private final CouponQueryService couponQueryService;

    // 페이징 추가 + 시큐리티 추가 해야함
    @GetMapping
    public Response<List<CouponSummary>> findAll(Long memberId) {
        List<CouponSummary> responses = couponQueryService.findAllByMemberId(memberId);
        return Response.ok(responses);
    }

    @PostMapping
    public Response<Long> issueCoupon(@RequestBody IssueCouponRequest request) {
        Long id = couponCommandService.issueCoupon(request);
        return Response.ok(id);
    }
}

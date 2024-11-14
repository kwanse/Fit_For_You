package com.kwanse.ably.coupon.query;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CouponSummaryDao extends MongoRepository<CouponSummary, String> {

    List<CouponSummary> findAllByMemberId(Long memberId);
}

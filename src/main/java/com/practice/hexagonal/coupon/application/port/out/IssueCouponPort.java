package com.practice.hexagonal.coupon.application.port.out;

import com.practice.hexagonal.coupon.domain.Coupon;

public interface IssueCouponPort {

    void issueCoupon(Coupon coupon);
}

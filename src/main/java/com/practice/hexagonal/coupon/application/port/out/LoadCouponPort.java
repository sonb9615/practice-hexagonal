package com.practice.hexagonal.coupon.application.port.out;

import com.practice.hexagonal.coupon.domain.Coupon;

public interface LoadCouponPort {

    Coupon loadCoupon(Coupon.CouponId couponId);
}

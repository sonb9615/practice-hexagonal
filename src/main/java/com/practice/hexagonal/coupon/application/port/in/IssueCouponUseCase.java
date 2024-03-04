package com.practice.hexagonal.coupon.application.port.in;

import com.practice.hexagonal.common.UseCase;

@UseCase
public interface IssueCouponUseCase {

    void issueCoupon(IssueCouponCommand command);
}

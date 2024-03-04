package com.practice.hexagonal.coupon.application.service;

import com.practice.hexagonal.coupon.application.port.in.IssueCouponCommand;
import com.practice.hexagonal.coupon.application.port.in.IssueCouponUseCase;
import com.practice.hexagonal.coupon.application.port.out.IssueCouponPort;
import com.practice.hexagonal.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IssueCouponService implements IssueCouponUseCase {

    private final IssueCouponPort issueCouponPort;

    @Transactional
    @Override
    public void issueCoupon(IssueCouponCommand command) {
        Coupon newCoupon = new Coupon(command.getMembershipPlanId(), command.getIssuerUserId());
        issueCouponPort.issueCoupon(newCoupon);
    }
}

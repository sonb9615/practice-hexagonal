package com.practice.hexagonal.coupon.adaptor.out;

import com.practice.hexagonal.common.PersistenceAdaptor;
import com.practice.hexagonal.coupon.application.port.out.IssueCouponPort;
import com.practice.hexagonal.coupon.domain.Coupon;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@PersistenceAdaptor
@RequiredArgsConstructor
public class CouponPersistenceAdaptor implements IssueCouponPort {

    private final CouponRepository couponRepository;
    private final MembershipPlanRepository membershipPlanRepository;

    @Override
    public void issueCoupon(Coupon coupon) {

        boolean membershipPlanExist = membershipPlanRepository.existsById(coupon.getMembershipPlanId().getId());
        if (!membershipPlanExist) {
            throw new EntityNotFoundException();
        }
        couponRepository.save(coupon.couponToEntity());
    }
}

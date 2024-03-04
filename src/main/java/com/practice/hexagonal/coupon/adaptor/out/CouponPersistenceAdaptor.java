package com.practice.hexagonal.coupon.adaptor.out;

import com.practice.hexagonal.common.PersistenceAdaptor;
import com.practice.hexagonal.coupon.application.port.out.IssueCouponPort;
import com.practice.hexagonal.coupon.application.port.out.LoadCouponPort;
import com.practice.hexagonal.coupon.application.port.out.RegisterCouponPort;
import com.practice.hexagonal.coupon.domain.Coupon;
import com.practice.hexagonal.coupon.domain.Membership;
import com.practice.hexagonal.coupon.domain.MembershipPlan;
import com.practice.hexagonal.coupon.domain.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@PersistenceAdaptor
@RequiredArgsConstructor
public class CouponPersistenceAdaptor implements IssueCouponPort , LoadCouponPort, RegisterCouponPort {

    private final CouponRepository couponRepository;
    private final MembershipPlanRepository membershipPlanRepository;
    private final MembershipRepository membershipRepository;

    @Override
    public void issueCoupon(Coupon coupon) {

        boolean membershipPlanExist = membershipPlanRepository.existsById(coupon.getMembershipPlanId().getId());
        if (!membershipPlanExist) {
            throw new EntityNotFoundException();
        }
        couponRepository.save(coupon.couponToEntity());
    }

    @Override
    public Coupon loadCoupon(Coupon.CouponId couponId) {

        CouponEntity couponEntity = couponRepository.findById(couponId.getId())
                .orElseThrow(EntityNotFoundException::new);

        return new Coupon(
                new Coupon.CouponId(couponEntity.getId())
                , new MembershipPlan.MembershipPlanId(couponEntity.getMembershipPlanId())
                , new User.UserId(couponEntity.getIssuerUserId())
                , new User.UserId(couponEntity.getUserId())
                , couponEntity.getStatus()
        );
    }

    @Override
    public void register(Coupon coupon) {
        CouponEntity couponEntity = coupon.couponToEntity();
        couponRepository.save(couponEntity);

        if (("active").equals(coupon.getStatus())) {
            MembershipEntity membership = new Membership(coupon.getMembershipPlanId(), coupon.getUserId()).membershipToEntity();
            membershipRepository.save(membership);
        }
    }
}

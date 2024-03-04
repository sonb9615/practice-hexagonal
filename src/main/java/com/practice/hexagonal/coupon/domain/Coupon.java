package com.practice.hexagonal.coupon.domain;

import com.practice.hexagonal.coupon.adaptor.out.CouponEntity;
import lombok.Value;

@Value
public class Coupon {

    private CouponId id;

    private MembershipPlan.MembershipPlanId membershipPlanId;

    private User.UserId issuerUserId;

    private User.UserId userId;

    private String status;

    public Coupon(MembershipPlan.MembershipPlanId membershipPlanId, User.UserId issuerUserId) {
        this.id = null;
        this.membershipPlanId = membershipPlanId;
        this.issuerUserId = issuerUserId;
        this.status = "ready";
        this.userId = null;
    }

    public CouponEntity couponToEntity(){
        return new CouponEntity(
                this.id.getId() == null ? null : this.id.getId()
                , this.membershipPlanId.getId()
                ,this.issuerUserId.getId()
                ,this.userId.getId()
                ,this.status
        );
    }

    @Value
    public static class CouponId{
        private final Long id;
    }

}

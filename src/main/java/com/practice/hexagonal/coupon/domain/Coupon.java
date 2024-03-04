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

    public Coupon(CouponId id, MembershipPlan.MembershipPlanId membershipPlanId, User.UserId issuerUserId, User.UserId userId, String status) {
        this.id = id;
        this.membershipPlanId = membershipPlanId;
        this.issuerUserId = issuerUserId;
        this.userId = userId;
        this.status = status;
    }

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
                ,this.userId.getId() == null ? null : this.userId.getId()
                ,this.status
        );
    }

    public Coupon(CouponId couponId, MembershipPlan.MembershipPlanId membershipPlanId, User.UserId issuerUserId, String status, User.UserId userId){
        this.id = couponId;
        this.membershipPlanId = membershipPlanId;
        this.issuerUserId = issuerUserId;
        this.status = status;
        this.userId = userId;
    }

    @Value
    public static class CouponId{
        private final Long id;
    }

}

package com.practice.hexagonal.coupon.application.port.in;

import com.practice.hexagonal.coupon.domain.Coupon.CouponId;
import com.practice.hexagonal.coupon.domain.MembershipPlan.MembershipPlanId;
import com.practice.hexagonal.coupon.domain.User.UserId;
import lombok.NonNull;
import lombok.Value;

@Value
public class RegisterCouponCommand {

    @NonNull
    private final MembershipPlanId targetMembershipPlanId;

    @NonNull
    private final CouponId targetCouponId;

    @NonNull
    private final UserId userId;

    public RegisterCouponCommand(MembershipPlanId targetMembershipPlanId, CouponId targetCouponId, UserId userId){
        this.targetMembershipPlanId = targetMembershipPlanId;
        this.targetCouponId = targetCouponId;
        this.userId = userId;
    }

}

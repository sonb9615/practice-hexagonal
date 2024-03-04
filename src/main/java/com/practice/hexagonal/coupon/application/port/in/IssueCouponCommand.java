package com.practice.hexagonal.coupon.application.port.in;


import com.practice.hexagonal.coupon.domain.MembershipPlan.MembershipPlanId;
import com.practice.hexagonal.coupon.domain.User.UserId;
import lombok.NonNull;
import lombok.Value;

@Value
public class IssueCouponCommand {

    @NonNull
    private final MembershipPlanId membershipPlanId;

    private final UserId issuerUserId;


    public IssueCouponCommand(MembershipPlanId membershipPlanId, UserId issuerUserId) {
        this.membershipPlanId = membershipPlanId;
        this.issuerUserId = issuerUserId;
    }
}

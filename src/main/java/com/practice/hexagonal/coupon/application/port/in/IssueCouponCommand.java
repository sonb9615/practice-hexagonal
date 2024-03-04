package com.practice.hexagonal.coupon.application.port.in;


import com.practice.hexagonal.coupon.domain.MembershipPlan.MembershipPlanId;
import com.practice.hexagonal.coupon.domain.User.IssuerUserId;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class IssueCouponCommand {

    @NonNull
    private final MembershipPlanId membershipPlanId;

    private final IssuerUserId issuerUserId;


    public IssueCouponCommand(MembershipPlanId membershipPlanId, IssuerUserId issuerUserId) {
        this.membershipPlanId = membershipPlanId;
        this.issuerUserId = issuerUserId;
    }
}

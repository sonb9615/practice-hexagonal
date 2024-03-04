package com.practice.hexagonal.coupon.adaptor.in;

import com.practice.hexagonal.coupon.application.port.in.IssueCouponCommand;
import com.practice.hexagonal.coupon.application.port.in.IssueCouponUseCase;
import com.practice.hexagonal.coupon.domain.MembershipPlan.MembershipPlanId;
import com.practice.hexagonal.coupon.domain.User.IssuerUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IssueCouponController {

    private final IssueCouponUseCase issueCouponUseCase;

    @PostMapping("/membershipPlan/{planId}/coupon/issue/by/{issuerId}")
    public void issue(@PathVariable Long planId, @PathVariable Long issuerId){

        IssueCouponCommand issueCouponCommand = new IssueCouponCommand(new MembershipPlanId(planId), new IssuerUserId(issuerId));
        issueCouponUseCase.issueCoupon(issueCouponCommand);
    }
}

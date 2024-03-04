package com.practice.hexagonal.coupon.adaptor.in;

import com.practice.hexagonal.coupon.application.port.in.RegisterCouponCommand;
import com.practice.hexagonal.coupon.application.port.in.RegisterCouponUseCase;
import com.practice.hexagonal.coupon.domain.Coupon.CouponId;
import com.practice.hexagonal.coupon.domain.MembershipPlan.MembershipPlanId;
import com.practice.hexagonal.coupon.domain.User.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterCouponController {

    private RegisterCouponUseCase registerCouponUseCase;

    @PostMapping("membershipPlan/{membershipPlanId}/coupon/{couponId}/register/by/userId/{userId}")
    public void register(@PathVariable Long membershipPlanId, @PathVariable Long couponId, @PathVariable Long userId){
        RegisterCouponCommand registerCouponCommand = new RegisterCouponCommand(new MembershipPlanId(membershipPlanId), new CouponId(couponId), new UserId(userId));
        registerCouponUseCase.registerCoupon(registerCouponCommand);
    }


}

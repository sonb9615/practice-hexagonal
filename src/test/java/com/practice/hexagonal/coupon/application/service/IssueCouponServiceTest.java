package com.practice.hexagonal.coupon.application.service;

import com.practice.hexagonal.coupon.application.port.in.IssueCouponCommand;
import com.practice.hexagonal.coupon.application.port.out.IssueCouponPort;
import com.practice.hexagonal.coupon.domain.MembershipPlan.MembershipPlanId;
import com.practice.hexagonal.coupon.domain.User.UserId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IssueCouponServiceTest {

    private final IssueCouponPort issueCouponPort = Mockito.mock(IssueCouponPort.class);
    private final IssueCouponService issueCouponService = new IssueCouponService(issueCouponPort);

    @Test
    void 쿠폰_발행_정상_작동() {
        MembershipPlanId membershipPlanId = new MembershipPlanId(1L);
        UserId issuerUserId = new UserId(1L);
        IssueCouponCommand issueCouponCommand = new IssueCouponCommand(membershipPlanId, issuerUserId);

        issueCouponService.issueCoupon(issueCouponCommand);
    }


}

package com.practice.hexagonal.coupon.application.service;

import com.practice.hexagonal.coupon.application.port.in.RegisterCouponCommand;
import com.practice.hexagonal.coupon.application.port.in.RegisterCouponUseCase;
import com.practice.hexagonal.coupon.application.port.out.LoadCouponPort;
import com.practice.hexagonal.coupon.application.port.out.LoadMembershipPort;
import com.practice.hexagonal.coupon.application.port.out.RegisterCouponPort;
import com.practice.hexagonal.coupon.domain.Coupon;
import com.practice.hexagonal.coupon.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterCouponService implements RegisterCouponUseCase {

    private final LoadCouponPort loadCouponPort;
    private final LoadMembershipPort loadMembershipPort;
    private final RegisterCouponPort registerCouponPort;

    @Override
    public void registerCoupon(RegisterCouponCommand registerCouponCommand) {

        Coupon targetCoupon = loadCouponPort.loadCoupon(registerCouponCommand.getTargetCouponId());
        //TODO 연속 등록 가능하도록
        List<Membership> memberships = loadMembershipPort.loadMemberships(registerCouponCommand.getTargetMembershipPlanId(), registerCouponCommand.getUserId());
        String status = "active";

        if (memberships.size() > 0) {
            status = "ready";
        }
        registerCouponPort.register(new Coupon(
                targetCoupon.getId()
                ,targetCoupon.getMembershipPlanId()
                ,targetCoupon.getIssuerUserId()
                , status
                ,targetCoupon.getUserId()
        ));
    }
}

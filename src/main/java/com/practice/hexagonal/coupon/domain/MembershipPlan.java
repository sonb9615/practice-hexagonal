package com.practice.hexagonal.coupon.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MembershipPlan {

    @Getter
    private final MembershipPlanId id;

    @Value
    public static class MembershipPlanId {
        Long id;
    }


}

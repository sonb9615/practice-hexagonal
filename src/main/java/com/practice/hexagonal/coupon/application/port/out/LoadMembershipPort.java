package com.practice.hexagonal.coupon.application.port.out;

import com.practice.hexagonal.coupon.domain.Membership;
import com.practice.hexagonal.coupon.domain.MembershipPlan.MembershipPlanId;
import com.practice.hexagonal.coupon.domain.User.UserId;

import java.util.List;

public interface LoadMembershipPort {

    List<Membership> loadMemberships(MembershipPlanId membershipPlanId, UserId userId);
}

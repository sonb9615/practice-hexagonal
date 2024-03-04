package com.practice.hexagonal.coupon.domain;

import com.practice.hexagonal.coupon.adaptor.out.MembershipEntity;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Value
public class Membership {

    private final MembershipId id;

    private final MembershipPlan.MembershipPlanId membershipPlanId;

    private final Long startedAt;

    private final Long endedAt;

    private final User.UserId userId;

    public Membership(MembershipId id, MembershipPlan.MembershipPlanId membershipPlanId, Long startedAt, Long endedAt, User.UserId userId) {
        this.id = id;
        this.membershipPlanId = membershipPlanId;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.userId = userId;
    }

    public Membership(MembershipPlan.MembershipPlanId membershipPlanId, User.UserId userId){
        this.id = null;
        this.membershipPlanId = membershipPlanId;
        this.startedAt = null;
        this.endedAt = null;
        this.userId = userId;
    }

    public MembershipEntity membershipToEntity(){

        LocalDateTime now = LocalDateTime.now();

        return new MembershipEntity(
                this.id.getId() == null ? null : this.id.getId()
                ,this.membershipPlanId.getId()
                , now.toEpochSecond(ZoneOffset.of("+09:00:00"))
                , now.plusMonths(1).toEpochSecond(ZoneOffset.of("+09:00:00"))
                , this.userId.getId()
        );
    }

    @Value
    public static class MembershipId{
        private final Long id;
    }
}

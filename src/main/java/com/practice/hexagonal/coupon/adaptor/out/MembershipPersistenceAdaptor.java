package com.practice.hexagonal.coupon.adaptor.out;

import com.practice.hexagonal.common.PersistenceAdaptor;
import com.practice.hexagonal.coupon.application.port.out.LoadMembershipPort;
import com.practice.hexagonal.coupon.domain.Membership;
import com.practice.hexagonal.coupon.domain.MembershipPlan;
import com.practice.hexagonal.coupon.domain.User;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@PersistenceAdaptor
@RequiredArgsConstructor
public class MembershipPersistenceAdaptor implements LoadMembershipPort {

    private final MembershipRepository membershipRepository;

    @Override
    public List<Membership> loadMemberships(MembershipPlan.MembershipPlanId membershipPlanId, User.UserId userId) {
        Long now = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+09:00:00"));
        List<MembershipEntity> activateMemberships = membershipRepository.findActivateMembership(membershipPlanId.getId(), userId.getId(), now);
        List<Membership> memberships = new ArrayList<>();
        for (MembershipEntity entity : activateMemberships) {
            Membership membership = new Membership(
                    new Membership.MembershipId(entity.getId())
                    , new MembershipPlan.MembershipPlanId(entity.getMembershipPlanId())
                    , entity.getStartedAt()
                    , entity.getEndedAt()
                    , new User.UserId(entity.getUserId())
            );
            memberships.add(membership);
        }

        return memberships;
    }
}

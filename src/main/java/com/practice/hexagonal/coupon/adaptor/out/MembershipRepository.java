package com.practice.hexagonal.coupon.adaptor.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembershipRepository extends JpaRepository<MembershipEntity, Long> {

    @Query("select m from MembershipEntity m where m.membershipPlanId = :membershipPlanId " +
            "and m.userId = :userId and m.startedAt <= :now and m.endedAt <= :now")
    public List<MembershipEntity> findActivateMembership(Long membershipPlanId, Long UserId, Long now);
}

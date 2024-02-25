package com.practice.hexagonal.coupon.adaptor.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership")
@NoArgsConstructor
public class MembershipEntity {

    @Id
    private Long id;

    private Long membershipPlanId;
    private Long startedAt;
    private Long endedAt;
    private Long userId;
}

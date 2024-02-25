package com.practice.hexagonal.coupon.adaptor.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "membership_plan")
public class MembershipPlanEntity {

    @Id
    private Long id;

    private String title;
    private Long startedAt;
    private Long endedAt;
    private Long userId;

}

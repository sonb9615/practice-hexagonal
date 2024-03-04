package com.practice.hexagonal.coupon.adaptor.out;

import jakarta.persistence.*;

@Entity
@Table(name = "membership_plan")
public class MembershipPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long startedAt;
    private Long endedAt;
    private Long userId;

}

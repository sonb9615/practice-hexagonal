package com.practice.hexagonal.coupon.adaptor.out;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MembershipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long membershipPlanId;
    private Long startedAt;
    private Long endedAt;
    private Long userId;
}

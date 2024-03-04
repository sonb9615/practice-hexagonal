package com.practice.hexagonal.coupon.adaptor.out;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coupon")
@AllArgsConstructor
@NoArgsConstructor
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long membershipPlanId;
    private Long issuerUserId;
    private Long userId;
    private String status;

}
